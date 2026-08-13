package tct1.linearstructure.bitwise;

/**
 * Problem: Single Number (LeetCode 136)
 * Time Complexity: O(N) - Single pass through the array.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR every element in the array
        for (int num : nums) {
            result ^= num; // Same as: result = result ^ num;
        }

        return result;
    }
}
