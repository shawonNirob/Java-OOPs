package codingInterview;

import java.util.Arrays;

public class Math {
    public static void main(String[] args) {
        int[][] intervals = {
                {3, 6, 2},
                {1, 4, 9},
                {7, 9, 1},
                {2, 5, 8}
        };

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        System.out.println("Sorted Intervals:");
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
