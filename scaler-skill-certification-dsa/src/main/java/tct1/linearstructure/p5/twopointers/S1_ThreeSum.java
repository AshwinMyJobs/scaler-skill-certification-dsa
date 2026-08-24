package tct1.linearstructure.p5.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PROBLEM STATEMENT: 3-Sum (Three Sum)
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Two Pointers Technique):
 * 1. Sort the array to easily handle duplicates and navigate using two pointers.
 * 2. Fix the first element (nums[i]) and turn the problem into a 2-Sum problem.
 * 3. Use two pointers ('left' at i+1 and 'right' at length-1) to find pairs that sum to -nums[i].
 * 4. Skip duplicate elements for 'i', 'left', and 'right' to ensure distinct triplets.
 *
 * Time Complexity:  O(N^2)
 * Space Complexity: O(1) or O(log N) depending on the sorting algorithm implementation.
 */

public class S1_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array to unlock two-pointer directional tracking
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Guard 1: Skip duplicate anchors to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid unique triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Guard 2: Slide pointers past duplicate values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both inward to look for new combinations
                    left++;
                    right--;

                } else if (sum < 0) {
                    // Sum is too small -> move left pointer to get a larger number
                    left++;
                } else {
                    // Sum is too big -> move right pointer to get a smaller number
                    right--;
                }
            }
        }

        return result;
    }
}
