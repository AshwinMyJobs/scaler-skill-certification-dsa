package tct1.linearstructure.p2.matrix;

/**
 * PROBLEM STATEMENT: Rotate Image (90 Degrees Clockwise)
 *
 * Given an n x n 2D matrix representing an image, rotate the image by 90 degrees
 * clockwise in-place. You must mutate the original matrix directly; do NOT allocate
 * another 2D matrix for the rotation.
 *
 * CORE INTUITION (The Transpose & Reverse Trick):
 * - Rotating a grid 90 degrees around its axis is equivalent to a two-step geometric reflection.
 * - Step 1: Transpose the matrix. Swap elements across the main diagonal (matrix[i][j] with matrix[j][i]).
 *   To avoid double-swapping back to the original form, the inner loop must always start at `j = i + 1`.
 * - Step 2: Reverse each row. Using a standard horizontal two-pointer sweep, flip every row elements.
 *
 * EXAMPLES:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Explanation:
 * - Transpose step yields: [[1,4,7],[2,5,8],[3,6,9]]
 * - Row reversal step yields: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N^2) where N is the length/width of the grid.
 * - Space Complexity: O(1) strictly constant auxiliary space.
 */

public class S1_RotateMatrix {

    public void rotate(int[][] matrix) {
        // Edge case safety check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;

        // Step 1: Transpose the matrix (Swap across the main diagonal)
        // j starts at i + 1 to avoid double-swapping elements back to their original spots
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row horizontally (Two-pointer technique)
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
