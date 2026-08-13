package tct1.linearstructure.bitwise;

/**
 * Problem: Number of 1 Bits (LeetCode 191)
 * Time Complexity: O(K) where K is the number of set bits (1s) in the number.
 *                  In the worst case, O(32) = O(1) constant time.
 * Space Complexity: O(1) constant auxiliary space.
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        hammingWeight(12);
    }

    public static int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            System.out.println(n);
            // This magical operation clears the lowest set bit
            n = n & (n - 1);
            count++; // Increment our count for every bit we clear
        }

        return count;
    }
}
