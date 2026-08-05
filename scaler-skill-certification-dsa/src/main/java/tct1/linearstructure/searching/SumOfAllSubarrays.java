package tct1.linearstructure.searching;

public class SumOfAllSubarrays {
    public static long sumOfAllSubArrays(int[] A){
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long) A[i] * (i+1) * (A.length - i);
        }
        return sum;
    }
}
