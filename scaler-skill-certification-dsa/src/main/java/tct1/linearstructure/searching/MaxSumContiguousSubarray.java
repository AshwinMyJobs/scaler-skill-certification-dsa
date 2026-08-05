package tct1.linearstructure.searching;

public class MaxSumContiguousSubarray {
    public static int maxSumContiguousSubarray(int[] A){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            currentSum = currentSum + A[i];

            if (maxSum < currentSum) maxSum = currentSum;

            if (currentSum < 0) currentSum = 0;

        }

        return maxSum;
    }
}
