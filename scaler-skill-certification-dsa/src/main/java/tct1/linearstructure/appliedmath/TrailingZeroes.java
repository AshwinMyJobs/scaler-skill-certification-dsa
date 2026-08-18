package tct1.linearstructure.appliedmath;

/**
 * Problem: Trailing Zeroes in Factorial (LeetCode 172)
 * Time Complexity: O(log5(N)) - Extremely fast because we divide by 5 each time.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;

        // Keep dividing n by powers of 5 (5, 25, 125...)
        while (n >= 5) {
            count += n / 5;
            n = n / 5; // Efficiently scale up our divisor by reducing n
        }

        return count;
    }
}
