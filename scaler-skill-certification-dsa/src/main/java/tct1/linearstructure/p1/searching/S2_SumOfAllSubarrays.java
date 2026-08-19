package tct1.linearstructure.p1.searching;

/**
 * PROBLEM STATEMENT: Sum of All Subarrays
 *
 * Given an array of integers, calculate the total sum of all elements across
 * every possible contiguous subarray.
 *
 * A brute-force approach generates all subarrays and sums them up, running in O(N^2) or O(N^3).
 * To achieve the optimal O(N) time, use the "Contribution Technique" by calculating
 * exactly how many subarrays contain each individual element at index i.
 *
 * THE CONTRIBUTION FORMULA:
 * Total subarrays containing index i = (i + 1) * (N - i)
 * Total contribution of nums[i] = nums[i] * (i + 1) * (N - i)
 *
 * EXAMPLES:
 * Input: nums = [1, 2, 3]
 * Output: 20
 * Explanation:
 * All possible subarrays are:
 * [1] -> sum 1
 * [2] -> sum 2
 * [3] -> sum 3
 * [1, 2] -> sum 3
 * [2, 3] -> sum 5
 * [1, 2, 3] -> sum 6
 * Total combined sum = 1 + 2 + 3 + 3 + 5 + 6 = 20
 *
 * Using Contribution Technique:
 * - Element 1 (index 0): 1 * (0 + 1) * (3 - 0) = 1 * 1 * 3 = 3
 * - Element 2 (index 1): 2 * (1 + 1) * (3 - 1) = 2 * 2 * 2 = 8
 * - Element 3 (index 2): 3 * (2 + 1) * (3 - 2) = 3 * 3 * 1 = 9
 * Total Sum = 3 + 8 + 9 = 20
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N) single pass.
 * - Space Complexity: O(1) constant memory.
 * - Watch out for integer overflow! (Use 'long' for the sum calculation if N is large).
 */
public class S2_SumOfAllSubarrays {
    public static long sumOfAllSubArrays(int[] A){
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long) A[i] * (i+1) * (A.length - i);
        }
        return sum;
    }
}
