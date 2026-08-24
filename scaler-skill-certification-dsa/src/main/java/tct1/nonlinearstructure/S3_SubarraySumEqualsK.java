package tct1.nonlinearstructure;

import java.util.HashMap;

/**
 * PROBLEM STATEMENT: Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: nums =, k = 2
 * Output: 2
 * Explanation: The valid subarrays are [1,1,_] (indices 0-1) and [_,1,1] (indices 1-2).
 *
 * Example 2:
 * Input: nums =, k = 3
 * Output: 2
 * Explanation: The valid subarrays are [1,2] (indices 0-1) and [3] (index 2).
 *
 * Example 3:
 * Input: nums =, k = 5
 * Output: 2
 * Explanation: The valid subarrays are [1,2,3] -> [2,3] at indices 1-2 and 4-5.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 1 <= nums.length <= 2 * 10^4
 * - -1000 <= nums[i] <= 1000
 * - -10^7 <= k <= 10^7
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Prefix Sum + Hashing Optimization):
 * 1. Maintain a single running tracking variable 'currentPrefixSum' on the fly.
 * 2. Use a HashMap to store the frequency of all prefix sums encountered: Map<Sum, Frequency>.
 * 3. Seed the map with (0, 1) to handle subarrays that sum to k starting directly from index 0.
 * 4. At each element:
 *    a. Add the element to 'currentPrefixSum'.
 *    b. Calculate the required complement: (currentPrefixSum - k).
 *    c. If this complement exists in the map, add its frequency count to our total answer.
 *    d. Record/Increment the current prefix sum's frequency inside the map.
 *
 * Time Complexity:  O(N) - We traverse the array exactly once.
 * Space Complexity: O(N) - In the worst case, the HashMap stores N distinct prefix sums.
 */
public class S3_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;

        // HashMap to store: Key = Prefix Sum, Value = Frequency of this sum
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: A prefix sum of 0 has been seen exactly 1 time initially
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            // Step 1: Update the running prefix sum on the fly
            currentPrefixSum += nums[i];

            // Step 2: Check if the complement (currentPrefixSum - k) exists behind us
            if (map.containsKey(currentPrefixSum - k)) {
                count += map.get(currentPrefixSum - k);
            }

            // Step 3: Put/Update the current prefix sum's frequency in the map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }
}
