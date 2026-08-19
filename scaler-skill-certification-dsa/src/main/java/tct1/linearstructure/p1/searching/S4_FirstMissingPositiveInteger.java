package tct1.linearstructure.p1.searching;

/**
 * PROBLEM STATEMENT: First Missing Positive Integer (Cyclic Sort / In-Place Hashing)
 *
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * The solution must run in O(N) time and use O(1) auxiliary space.
 * This means you cannot use a HashSet or a new array to track numbers.
 *
 * CORE INTUITION (The Valet Parking Trick):
 * - For an array of length N, the first missing positive number MUST fall within the range [1, N + 1].
 * - Use the original array as its own hash map.
 * - Try to place every valid integer X (where 1 <= X <= N) at its correct index position (X - 1) using swaps.
 * - Use a while loop condition `nums[i] != nums[nums[i] - 1]` to safely avoid infinite loops with duplicate values.
 *
 * EXAMPLES:
 * Input: nums = [1, 2, 0]
 * Output: 3
 * Explanation: Numbers 1 and 2 are in the array. The smallest missing positive is 3.
 *
 * Input: nums = [3, 4, -1, 1]
 * Output: 2
 * Explanation: After sorting in-place, the array becomes [1, -1, 3, 4].
 * Index 1 contains -1 instead of 2, so 2 is missing.
 *
 * Input: nums = [7, 8, 9, 11, 12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing entirely.
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N) linear time (each element is swapped at most twice).
 * - Space Complexity: O(1) constant auxiliary space.
 */
public class S4_FirstMissingPositiveInteger {
    public static int firstMissingPositiveInteger(int[] A){

        for (int i = 0; i < A.length; i++) {
            // 1. Check bounds: 1 <= A[i] <= A.length
            // 2. Check duplicates: Ensure the number at the target home is not already correct
            while (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int correctIdx = A[i] - 1; // Calculate target index safely

                // Classic, safe 3-step swap using correctIdx
                int temp = A[i];
                A[i] = A[correctIdx];
                A[correctIdx] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if(A[i]!=i+1) return i+1;
        }

        return -1;

    }
}