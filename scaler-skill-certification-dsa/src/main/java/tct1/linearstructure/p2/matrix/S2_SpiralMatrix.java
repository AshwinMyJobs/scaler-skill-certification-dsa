package tct1.linearstructure.p2.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * PROBLEM STATEMENT: SPIRAL MATRIX
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Input: matrix = [
 *,
 *,
 *   [7, 8, 9]
 * ]
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 10
 * - -100 <= matrix[i][j] <= 100
 */

/**
 * Problem: Spiral Matrix (LeetCode 54)
 * Time Complexity: O(M * N) - Every element is visited exactly once.
 * Space Complexity: O(1) - Auxiliary space (excluding the output list).
 */
public class S2_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // Edge case safety check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // Initialize our 4 dynamic boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Loop runs until boundaries cross each other
        while (top <= bottom && left <= right) {

            // 1. Move Right: Across the current 'top' row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Top row is done, shrink boundary down

            // 2. Move Down: Down the current 'right' column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Right column is done, shrink boundary left

            // 3. Move Left: Across the current 'bottom' row
            // 🚨 CRITICAL CHECK: Ensure top and bottom haven't crossed yet
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Bottom row is done, shrink boundary up
            }

            // 4. Move Up: Up the current 'left' column
            // 🚨 CRITICAL CHECK: Ensure left and right haven't crossed yet
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Left column is done, shrink boundary right
            }
        }

        return result;
    }
}
