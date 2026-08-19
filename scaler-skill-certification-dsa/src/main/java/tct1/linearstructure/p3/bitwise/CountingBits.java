package tct1.linearstructure.p3.bitwise;

/**
 * Problem: Counting Bits (LeetCode 338)
 * Time Complexity: O(N) - Linear single pass.
 * Space Complexity: O(1) - Constant auxiliary space (excluding output array).
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        // Base case: ans[0] is already 0 by default in Java
        for (int i = 1; i <= n; i++) {
            // Number of bits = bits in (i / 2) + 1 if i is odd
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
