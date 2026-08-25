package tct1.searchingandsorting.p1.binarysearch;

/**
 * PROBLEM STATEMENT: Rotated Sorted Array Search
 *
 * Given an array of integers 'nums' sorted in ascending order that has been rotated
 * at an unknown pivot, find the index of a given 'target' element. If the target
 * is not found, return -1.
 *
 * THE CORE INTUITION:
 * Even though the global array loses its complete sorted order due to rotation,
 * if you calculate the middle element 'mid', AT LEAST ONE HALF (either the left half
 * from 'low' to 'mid' or the right half from 'mid' to 'high') is GUARANTEED to be
 * perfectly sorted in ascending order.
 *
 * ALGORITHM MECHANICS (OPTIMAL ONE-PASS BINARY SEARCH):
 * 1. Find which half is sorted by comparing nums[low] with nums[mid].
 * 2. Check if the target falls within the boundary values of that sorted half.
 * 3. If it does, eliminate the other half. If it doesn't, eliminate the sorted half.
 *
 * EXAMPLES:
 * Input: nums =, target = 0
 * Output: 4
 * Explanation: The array is rotated. 0 is found at index 4.
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(log N) single pass.
 * - Space Complexity: O(1) constant memory.
 * - Overflow Prevention: Uses 'low + (high - low) / 2' to calculate mid safely.
 */
public class S2_RotatedSortedArraySearch {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Compute middle index safely to prevent integer overflow
            int mid = low + (high - low) / 2;

            // If the target is found at the midpoint, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // CASE 1: Check if the left half is perfectly sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target lies strictly inside the sorted left half range
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Narrow search space to the left half
                } else {
                    low = mid + 1;  // Target must be in the right half
                }
            }
            // CASE 2: The right half must be perfectly sorted
            else {
                // Check if the target lies strictly inside the sorted right half range
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Narrow search space to the right half
                } else {
                    high = mid - 1; // Target must be in the left half
                }
            }
        }

        // Target was not found anywhere within the search space boundaries
        return -1;
    }
}
