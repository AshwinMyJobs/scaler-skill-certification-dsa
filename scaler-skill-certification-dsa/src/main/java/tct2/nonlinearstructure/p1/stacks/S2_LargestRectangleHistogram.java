package tct2.nonlinearstructure.p1.stacks;

import java.util.Stack;

public class S2_LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Treat index 'n' as a dummy bar of height 0 to force-flush everything left in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // Loop: while the current bar is shorter than the bar on top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int nse = i; // Nearest Smaller to the Right
                int pse = stack.isEmpty() ? -1 : stack.peek(); // Nearest Smaller to the Left

                int width = nse - pse - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
