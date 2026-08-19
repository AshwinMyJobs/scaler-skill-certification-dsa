package tct1.linearstructure.p1.searching;

/**
 * PROBLEM STATEMENT: Equilibrium Index of an Array
 *
 * Given an array of integers, find the first index where the sum of elements
 * at lower indices is equal to the sum of elements at higher indices.
 *
 * Formally, find an index i such that:
 * (Sum of elements from index 0 to i-1) == (Sum of elements from index i+1 to N-1)
 *
 * If no such equilibrium index exists, return -1.
 * If there are multiple equilibrium indices, return the first/smallest index.
 *
 * EXAMPLES:
 * Input: nums = [-7, 1, 5, 2, -4, 3, 0]
 * Output: 3
 * Explanation:
 * - Sum of elements left of index 3:  (-7) + 1 + 5 = -1
 * - Sum of elements right of index 3: (-4) + 3 + 0 = -1
 *
 * Input: nums = [1, 2, 3]
 * Output: -1
 * Explanation: No index balances the left and right sums perfectly.
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N) using a Prefix Sum / Running Total strategy.
 * - Space Complexity: O(1) by maintaining a single total sum.
 */


public class S1_EqulibriumIndex {

    public static int getEqulibriumIndex(int[] intArray){

        int totalSum = 0;

        for (int i = 0; i < intArray.length; i++) {
            totalSum += intArray[i];
        }

        int leftSum = intArray[0];
        int righSum = totalSum;

        for (int i = 0; i < intArray.length; i++) {
            leftSum = intArray[i];
            righSum = totalSum -(leftSum + intArray[i]);
            if(leftSum==righSum) return i;
            leftSum = leftSum + intArray[i];
        }

        return -1;
    }
}
