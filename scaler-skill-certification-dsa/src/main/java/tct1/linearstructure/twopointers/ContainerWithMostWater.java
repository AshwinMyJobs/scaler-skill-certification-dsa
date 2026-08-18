package tct1.linearstructure.twopointers;

/**
 * Problem: Container With Most Water (LeetCode 11)
 * Time Complexity: O(N) - Linear single pass with two pointers.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class ContainerWithMostWater {

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
