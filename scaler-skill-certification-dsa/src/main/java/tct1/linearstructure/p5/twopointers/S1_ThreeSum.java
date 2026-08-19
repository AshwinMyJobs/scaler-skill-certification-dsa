package tct1.linearstructure.p5.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 3Sum (LeetCode 15)
 * Time Complexity: O(N^2) - Sorting takes O(N log N), nested loops take O(N^2).
 * Space Complexity: O(1) - Auxiliary space (excluding output list memory).
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
