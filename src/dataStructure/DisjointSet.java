package dataStructure;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DisjointSet {
    public static int[] parrent;
    public static int[] rank;
    public static int[] size;

    public DisjointSet(int V){
        parrent = new int[V];
        rank = new int[V];
        size = new int[V];

        for(int i=0; i<V; i++){
            parrent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }
    //Path Compression
    public int find(int u){
        if(parrent[u] == u){
            return u;
        }else{
            return parrent[u] = find(parrent[u]);
        }
    }
    public void unionByRank(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        //cycle detection
        if(rootX==rootY){
            System.out.println("Cycle detected");
            return;
        }

        if(rank[rootX] > rank[rootY]){
            parrent[rootY] = rootX;
        }else if(rank[rootX] < rank[rootY]) {
            parrent[rootX] = rootY;
        }else{
            parrent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public void unionBySize(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        //cycle detection
        if(rootX==rootY){
            System.out.println("Cycle detected");
            return;
        }

        if(size[rootX] > size[rootY]){
            parrent[rootY] = rootX;
            size[rootX] += size[rootY];
        } else if (size[rootX] < size[rootY]) {
            parrent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else{
            parrent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(9);
        set.unionBySize(1,2);
        set.unionBySize(2,3);
        set.unionBySize(4,5);
        set.unionBySize(6,7);
        set.unionBySize(5,6);
        set.unionBySize(3,7);
        //set.unionByRank(2,5);

        System.out.println(set.find(1));
        //System.out.println(set.find(2)); //For path compression
        //System.out.println(set.find(3));
        System.out.println(set.find(4));
        System.out.println(set.find(5));
        System.out.println(set.find(6));
        System.out.println(set.find(7));
        System.out.println(set.find(8));

        for(int i=1; i<9; i++){
            System.out.println("Node of "+i+" Parrent: "+parrent[i]+" rank: "+size[i]);
        }
    }
}
