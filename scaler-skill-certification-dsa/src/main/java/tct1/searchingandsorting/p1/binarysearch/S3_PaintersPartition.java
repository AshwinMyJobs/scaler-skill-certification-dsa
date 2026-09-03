package tct1.searchingandsorting.p1.binarysearch;

/**
 * PROBLEM STATEMENT: Painters Partition Problem
 *
 * Given 'A' painters, where each painter takes 'B' units of time to paint 1 unit of a board,
 * and an array 'C' representing the lengths of contiguous boards, find the MINIMUM TIME
 * required to paint all the boards.
 *
 * RULES:
 * 1. A painter can only paint contiguous sections of boards.
 * 2. All painters work simultaneously. The total time is determined by the busiest painter.
 * 3. Return the final total time modulo 10000003.
 *
 * STRATEGY (BINARY SEARCH ON ANSWER SPACE):
 * Instead of searching array indices, we search the "maximum board length a single painter handles".
 * - Range Low: The single largest board length (even with infinite painters, someone must paint this).
 * - Range High: The sum of all board lengths (the work done if we only had 1 painter).
 *
 * For every midpoint, we use a greedy approach to check if 'A' painters can complete the job
 * without anyone exceeding 'mid' units of work.
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N * log(Sum of Boards)) where N is the number of boards.
 * - Space Complexity: O(1) auxiliary constant memory.
 */
public class S3_PaintersPartition {

    public static int paint(int A, int B, int[] C) {
        long low = 0;
        long high = 0;
        long ans = 0;
        long MOD = 10000003;

        // Establish Binary Search bounds based on board lengths
        for (int board : C) {
            low = Math.max(low, board); // Busiest painter must at least take the maximum board
            high += board;              // Worst-case scenario total sum
        }

        // Binary Search on Answer Space
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(C, A, mid)) {
                ans = mid;         // 'mid' is valid, record it as a potential optimal length
                high = mid - 1;    // Try to find a smaller, tighter maximum limit
            } else {
                low = mid + 1;     // Limit too small, expand allowed workload capacity
            }
        }

        // Calculate total time: (Optimal Length * Time per unit) % MOD
        long totalTime = (ans % MOD * B % MOD) % MOD;
        return (int) totalTime;
    }

    /**
     * Helper method to validate if 'allocatedPainters' can complete all boards
     * without any single painter exceeding the 'maxWorkLimit'.
     */
    private static boolean isPossible(int[] C, int allocatedPainters, long maxWorkLimit) {
        int paintersUsed = 1;
        long currentWorkload = 0;

        for (int board : C) {
            if (currentWorkload + board <= maxWorkLimit) {
                currentWorkload += board; // Keep assigning to the current painter
            } else {
                paintersUsed++;           // Call in the next painter
                currentWorkload = board;  // Reset current workload with the new board

                if (paintersUsed > allocatedPainters) {
                    return false;         // Ran out of available painters
                }
            }
        }
        return true;
    }
}
