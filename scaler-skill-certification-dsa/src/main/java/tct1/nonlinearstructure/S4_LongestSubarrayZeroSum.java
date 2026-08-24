package tct1.nonlinearstructure;

import java.util.HashMap;

/**
 * PROBLEM STATEMENT: Longest Subarray with Sum 0
 *
 * Given an array of integers A, find the length of the longest contiguous
 * subarray that sums up to exactly 0. If no such subarray exists, return 0.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: A = [15, -2, 2, -8, 1, 7, 10, 23]
 * Output: 5
 * Explanation: The longest subarray with 0 sum is [-2, 2, -8, 1, 7] from index 1 to 5.
 *
 * Example 2:
 * Input: A = [1, 2, 3]
 * Output: 0
 * Explanation: There is no contiguous subarray that sums up to 0.
 *
 * Example 3:
 * Input: A = [5, -5, 3]
 * Output: 2
 * Explanation: The subarray [5, -5] from index 0 to 1 sums to 0. Length = 1 - (-1) = 2.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 1 <= A.length <= 10^5
 * - -10^5 <= A[i] <= 10^5
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Prefix Sum + First Occurrence Hashing):
 * 1. Maintain a running variable 'currentPrefixSum' on the fly.
 * 2. Use a HashMap to store the *earliest index* where a prefix sum is seen: Map<Sum, EarliestIndex>.
 * 3. Seed the map with (0, -1) to handle 0-sum subarrays starting from index 0.
 * 4. At each element:
 *    a. Add the element to 'currentPrefixSum'.
 *    b. If this sum has been seen before, a 0-sum subarray exists between the previous
 *       occurrence and the current index. Calculate length = (current_index - earliest_index).
 *    c. Maximize the global length tracking variable.
 *    d. If the sum is brand new, store it with the current index. If it already exists,
 *       do NOT update it (keeping the older index yields a longer subarray).
 *
 * Time Complexity:  O(N) - Single pass through the array.
 * Space Complexity: O(N) - Worst case scenario where all prefix sums are distinct.
 */
public class S4_LongestSubarrayZeroSum {
    public int solve(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // HashMap to store: Key = Prefix Sum, Value = Earliest index where it appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        int currentPrefixSum = 0;
        int maxLength = 0;

        // Base case: A prefix sum of 0 happens at virtual index -1
        map.put(0, -1);

        for (int i = 0; i < A.length; i++) {
            // Step 1: Accumulate prefix sum on the fly
            currentPrefixSum += A[i];

            // Step 2: Check if this prefix sum has been encountered before
            if (map.containsKey(currentPrefixSum)) {
                int earliestIndex = map.get(currentPrefixSum);
                int currentLength = i - earliestIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Step 3: Only store if it's the first occurrence to maximize length
                map.put(currentPrefixSum, i);
            }
        }

        return maxLength;
    }
}
