package tct1.nonlinearstructure;

/**
 * PROBLEM STATEMENT: Maximum Sum Subarray of Size K
 *
 * Given an array of integers A and a positive integer k, find the maximum sum
 * of any contiguous subarray of size k.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: A = [3, 2, 7, -1, 4], k = 3
 * Output: 12
 * Explanation: The subarray [3, 2, 7] gives the maximum sum of 12.
 *
 * Example 2:
 * Input: A =, k = 2
 * Output: 700
 * Explanation: The subarray [300, 400] gives the maximum sum of 700.
 *
 * Example 3:
 * Input: A =, k = 4
 * Output: 39
 * Explanation: The subarray [4, 2, 10, 23] gives the maximum sum of 39.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 1 <= A.length <= 10^5
 * - -10^5 <= A[i] <= 10^5
 * - 1 <= k <= A.length
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Fixed-Size Sliding Window):
 * 1. Compute the sum of the very first window of size k (indices 0 to k-1) sequentially.
 * 2. Initialize 'maxSum' with this initial window sum.
 * 3. Slide the window from index k to the end of the array.
 * 4. At each step, update the sum by adding the new right element (A[i]) and subtracting
 *    the old element leaving the window from the left (A[i - k]).
 * 5. Track the maximum sum found across all windows using Math.max().
 *
 * Time Complexity:  O(N) - Single pass traversal through the array.
 * Space Complexity: O(1) - Uses constant auxiliary memory space.
 */
public class S1_MaxSumSubarrayWithSizeK {
    public int maxSubarraySum(int[] A, int k) {
        // Edge case: If array size is smaller than window size or invalid k
        if (A == null || A.length < k || k <= 0) {
            return 0;
        }

        int currentSum = 0;

        // 1. Compute the sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += A[i];
        }

        int maxSum = currentSum;

        // 2. Slide the window across the rest of the array
        for (int i = k; i < A.length; i++) {
            // Add current element (right), subtract out-of-bounds element (left)
            currentSum += A[i] - A[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
