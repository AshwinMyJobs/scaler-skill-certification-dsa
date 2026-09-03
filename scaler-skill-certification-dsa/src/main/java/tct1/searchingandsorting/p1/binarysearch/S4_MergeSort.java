package tct1.searchingandsorting.p1.binarysearch;

/**
 * PROBLEM STATEMENT: Merge Sort Implementation
 *
 * Implement the classic Merge Sort algorithm to sort an array of integers
 * in ascending order using the Divide and Conquer strategy.
 *
 * ALGORITHM MECHANICS:
 * 1. Divide: Calculate the midpoint 'mid' and recursively split the array into
 *    left and right halves until individual elements are reached (base case: size <= 1).
 * 2. Conquer (Merge): Use a two-pointer approach to combine the two sorted halves
 *    into a single sorted array segment using a temporary array.
 *
 * CONSTRAINTS / OPTIMAL TARGET:
 * - Time Complexity: O(N log N) in all cases (best, average, worst).
 * - Space Complexity: O(N) auxiliary space for the temporary merging arrays.
 * - Stability: Merge Sort is a stable sorting algorithm (preserves relative order of duplicates).
 */
public class S4_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    // Recursive function to split the array
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            // Sort left and right halves
            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Helper function to merge two sorted segments
    private static void merge(int[] arr, int low, int mid, int high) {
        // Create sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) leftArr[i] = arr[low + i];
        for (int j = 0; j < n2; ++j) rightArr[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = low; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArr[] if any
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArr[] if any
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
