package tct1.linearstructure.matrix;

/**
 * Problem: Rotate Image (LeetCode 48)
 * Time Complexity: O(N^2) where N is the matrix length.
 * Space Complexity: O(1) Auxiliary space (In-place rotation).
 */
public class RotateMatrix {

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
