package tct1.linearstructure.appliedmath;

/**
 * Problem: Excel Sheet Column Number (LeetCode 171)
 * Time Complexity: O(N) where N is the length of the string.
 * Space Complexity: O(1) Auxiliary space.
 */
public class ExcelColumnNumber {

    public int titleToNumber(String columnTitle) {
        // Edge case safety check
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }

        int total = 0;

        // Loop through the string from left to right
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);

            // Convert character 'A'-'Z' to integer value 1-26
            int value = c - 'A' + 1;

            // Shift previous total left by base-26 and add current value
            total = (total * 26) + value;
        }

        return total;
    }
}
