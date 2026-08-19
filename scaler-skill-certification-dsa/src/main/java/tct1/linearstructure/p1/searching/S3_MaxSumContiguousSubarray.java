package tct1.linearstructure.p1.searching;

/**
 * PROBLEM STATEMENT: Maximum Sum Contiguous Subarray (Kadane's Algorithm)
 *
 * Given an integer array nums, find the contiguous subarray (containing at least
 * one number) which has the largest sum and return its sum.
 *
 * CORE INTUITION (Kadane's Greedy Strategy):
 * - Maintain a running currentSum.
 * - If currentSum ever drops below 0, it becomes a liability for future elements.
 *   We instantly discard it and reset it to 0.
 * - Track the historical maximum seen so far using standard global max comparisons.
 *
 * EXAMPLES:
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Input: nums = [5, 4, -1, 7, 8]
 * Output: 23
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N) single linear pass.
 * - Space Complexity: O(1) constant extra storage.
 * - Edge Case: If the array contains all negative numbers, make sure your initial
 *   maxSum tracks the highest single negative number rather than defaulting to 0.
 */

public class S3_MaxSumContiguousSubarray {
    public static int maxSumContiguousSubarray(int[] A){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            currentSum = currentSum + A[i];

            if (maxSum < currentSum) maxSum = currentSum;

            if (currentSum < 0) currentSum = 0;

        }

        return maxSum;
    }
}
