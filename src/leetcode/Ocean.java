package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ocean {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(heights[i][j], i, j, heights, new boolean[m][n],m,n, false, false)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }
    public boolean dfs(int parr, int r, int c, int[][] heights, boolean[][] visited, int m, int n, boolean pacific, boolean atlantic){

        if(r<0 || r>=m || c<0 || c>=n || heights[r][c] > parr || visited[r][c]) return false;

        if(r==0 || c==0) pacific = true;
        if(r==m-1 || c==n-1) atlantic = true;

        if(pacific && atlantic) return true;

        visited[r][c] = true;

        int[] rp = {0, 0, -1, 1};
        int[] cp = {-1, 1, 0, 0};

        for(int i=0; i<4; i++){
            int row = r+rp[i];
            int col = c+cp[i];

            if(dfs(heights[r][c], row, col,heights, visited, m, n, pacific, atlantic)){
                return true;
            }
        }
        visited[r][c] = false;

        return false;
    }

    public static void main(String[] args) {
        Ocean obj = new Ocean();
           int[][] heights =  {{1, 2, 2, 3, 5},
             {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}};

        List<List<Integer>> list = obj.pacificAtlantic(heights);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
