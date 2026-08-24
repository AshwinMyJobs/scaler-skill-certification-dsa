package tct1.nonlinearstructure;

import java.util.HashMap;

/**
 * PROBLEM STATEMENT: Longest Subarray with Sum B
 *
 * Given an array of integers A and an integer B, find the length of the longest
 * contiguous subarray that sums up to exactly B. If no such subarray exists, return 0.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: A =, B = 15
 * Output: 4
 * Explanation: The longest subarray with sum 15 is [5, 2, 7, 1] from index 1 to 4.
 *
 * Example 2:
 * Input: A = [-1, 2, 3], B = 6
 * Output: 0
 * Explanation: No contiguous subarray sums up to 6.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 1 <= A.length <= 10^5
 * - -10^5 <= A[i] <= 10^5
 * - -10^9 <= B <= 10^9
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Prefix Sum + First Occurrence Hashing):
 * 1. Maintain a single tracking variable 'currentPrefixSum' on the fly.
 * 2. Use a HashMap to store the *earliest index* of each prefix sum: Map<Sum, EarliestIndex>.
 * 3. Seed the map with (0, -1) to catch valid windows starting immediately at index 0.
 * 4. At each element:
 *    a. Add the element to 'currentPrefixSum'.
 *    b. Calculate the required complement: (currentPrefixSum - B).
 *    c. If this complement exists in the map, compute length = (current_index - earliest_index).
 *    d. Maximize the global length tracking variable.
 *    e. If 'currentPrefixSum' is a brand new sum, store it. If it already exists,
 *       leave the older index untouched to maximize future lengths.
 *
 * Time Complexity:  O(N) - Single pass through the array.
 * Space Complexity: O(N) - Worst case scenario where all cumulative sums are distinct.
 */
public class S5_LongestSubarraySumB {
    public int solve(int[] A, int B) {
        if (A == null || A.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int currentPrefixSum = 0;
        int maxLength = 0;

        // Base case: A cumulative sum of 0 is conceptually located at index -1
        map.put(0, -1);

        for (int i = 0; i < A.length; i++) {
            currentPrefixSum += A[i];

            // Check if the complement exists behind us
            if (map.containsKey(currentPrefixSum - B)) {
                int earliestIndex = map.get(currentPrefixSum - B);
                maxLength = Math.max(maxLength, i - earliestIndex);
            }

            // Only add the current sum if it has never been seen before
            if (!map.containsKey(currentPrefixSum)) {
                map.put(currentPrefixSum, i);
            }
        }

        return maxLength;
    }
}

