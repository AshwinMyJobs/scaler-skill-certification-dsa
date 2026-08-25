package tct1.searchingandsorting.p1.binarysearch;

/**
 * PROBLEM STATEMENT: Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be if it
 * were inserted in order.
 *
 * ALGORITHM MECHANICS (OPTIMAL BINARY SEARCH):
 * Instead of scanning linearly in O(N), we use the binary search strategy to divide
 * the search space in half at each step. This ensures O(log N) performance.
 *
 * THE INNER POINTER TRICK:
 * If the element is found during the loop, we return 'mid' immediately.
 * If the target doesn't exist, the while loop condition (low <= high) will eventually
 * break when 'low' and 'high' cross each other. At that precise moment of termination,
 * the 'low' pointer points exactly to the insertion index where the element belongs.
 *
 * EXAMPLES:
 * Input: nums = [1, 3, 5, 6], target = 5
 * Output: 2
 * Explanation: 5 is found at index 2.
 *
 * Input: nums = [1, 3, 5, 6], target = 2
 * Output: 1
 * Explanation: 2 is missing, but it belongs between 1 and 3 (index 1).
 *
 * Input: nums = [1, 3, 5, 6], target = 7
 * Output: 4
 * Explanation: 7 is greater than all elements, so it belongs at the very end (index 4).
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(log N) logarithmic search space reduction.
 * - Space Complexity: O(1) auxiliary constant memory.
 * - Overflow Prevention: Uses 'low + (high - low) / 2' to compute mid safely.
 */
public class S1_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Compute middle index safely to prevent integer overflow
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return its index position
            } else if (nums[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        // When low > high, 'low' represents the correct insertion index
        return low;
    }
}
