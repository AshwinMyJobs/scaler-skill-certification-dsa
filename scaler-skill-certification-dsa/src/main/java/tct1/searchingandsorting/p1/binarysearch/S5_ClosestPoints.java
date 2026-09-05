package tct1.searchingandsorting.p1.binarysearch;

import java.util.Arrays;

public class S5_ClosestPoints {
    public int[][] solve(int[][] points, int B) {
        // Sort the array using a custom comparator based on squared distance
        Arrays.sort(points, (p1, p2) -> {
            long d1 = (long) p1[0] * p1[0] + (long) p1[1] * p1[1];
            long d2 = (long) p2[0] * p2[0] + (long) p2[1] * p2[1];
            return Long.compare(d1, d2);
        });

        // Copy and return the first B elements
        return Arrays.copyOfRange(points, 0, B);
    }
}

