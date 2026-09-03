package tct1.nonlinearstructure;

import java.util.HashSet;

/**
 * PROBLEM STATEMENT: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * ---------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * ---------------------------------------------------------------------------------
 * CONSTRAINTS:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols, and spaces.
 *
 * ---------------------------------------------------------------------------------
 * APPROACH (Variable-Size Sliding Window + HashSet):
 * 1. Maintain a dynamic window using two pointers: 'left' and 'right'.
 * 2. Use a HashSet to track all unique characters currently present inside the window.
 * 3. Expand the window by moving the 'right' pointer forward.
 * 4. If a duplicate character is encountered, shrink the window from the 'left' side
 *    by removing elements from the HashSet until the duplicate character is eliminated.
 * 5. Update the global maximum length at each valid step using (right - left + 1).
 *
 * Time Complexity:  O(N) - Each character is visited at most twice (once by right, once by left).
 * Space Complexity: O(W) - Where W is the size of the character set (at most O(1) auxiliary space if bounded).
 */
public class S2_LongestSubstringWithOutRepeatingCharecter {
    public int lengthOfLongestSubstring(String s) {
        // Edge case: empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        // 'right' expands the window boundary
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Shrink the window from the left if the character is a duplicate
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Insert the current character into the unique set
            set.add(currentChar);

            // Compute current window size and maximize
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

