package tct1.linearstructure.p5.twopointers;

/**
 * PROBLEM STATEMENT: Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array.
 * In this case, the max area of water the container can contain is 49 (between index 1 and 8).
 * Area = min(height[1], height[8]) * (8 - 1) = min(8, 7) * 7 = 7 * 7 = 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * Explanation: Area = min(1, 1) * (1 - 0) = 1 * 1 = 1.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Greedy Two Pointers):
 * 1. Initialize two pointers at the extreme ends of the array: 'left' at 0 and 'right' at n-1.
 * 2. Calculate the area formed between the two lines: width = right - left, height = min(height[left], height[right]).
 * 3. Update the 'maxWater' tracking variable.
 * 4. Move the pointer pointing to the shorter line inward. Moving the longer line cannot
 *    increase the height limit but will strictly decrease the width, yielding a smaller area.
 *
 * Time Complexity:  O(N) - Single pass through the array.
 * Space Complexity: O(1) - Constant auxiliary space used.
 */

public class S2_ContainerWithMostWater {

    public int maxArea(int[] height) {
        // Edge case safety check
        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        // Loop runs until the two pointers meet
        while (left < right) {
            int width = right - left;

            // The water level is limited by the shorter wall
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate current area and update the running global maximum
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter wall inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
