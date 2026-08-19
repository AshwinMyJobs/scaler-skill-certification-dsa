package tct1.linearstructure.p1.searching;

/**
 * PROBLEM STATEMENT: Trapping Rain Water
 *
 * Given an array of non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it can trap after raining.
 *
 * CORE INTUITION (The Boundary Trap):
 * - The water level above any individual bar at index i is determined by the
 *   tallest wall to its absolute left and the tallest wall to its absolute right.
 * - Formula: Water at index i = Math.max(0, Math.min(maxLeft, maxRight) - heights[i])
 * - This can be solved by precomputing prefix-maximum and suffix-maximum arrays,
 *   or optimized into a single pass using a two-pointer approach converging from both ends.
 *
 * EXAMPLES:
 * Input: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * Output: 6
 * Explanation: The elevation map is represented by array.
 * In this case, 6 units of rain water are being trapped.
 *
 * Input: height = [4, 2, 0, 3, 2, 5]
 * Output: 9
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N) linear time to scan the structures.
 * - Space Complexity: O(N) if using prefix/suffix max arrays, or optimized to O(1) using two pointers.
 */
public class S5_RainWaterTrapping {
    public static int rainWaterTrapping(int[] A){
        int[] leftMaxArray = new int[A.length];
        leftMaxArray[0] = A[0];
        int[] rightMaxArray = new int[A.length];
        rightMaxArray[A.length-1] = A[A.length-1];
        int leftMax = A[0];
        int rightMax = A[A.length-1];

        for (int i = 1; i < A.length; i++) {
            if(leftMax<A[i]) leftMax = A[i];
            leftMaxArray[i] = leftMax;
        }

        for (int i = A.length-1; i >= 0 ; i--) {
            if(rightMax<A[i]) rightMax = A[i];
            rightMaxArray[i] = rightMax;
        }

        int totalWaterStored = 0;
        for (int i = 0; i < A.length; i++) {
            totalWaterStored += Math.min(leftMaxArray[i],rightMaxArray[i])-A[i];
        }
        return totalWaterStored;
    }
}
