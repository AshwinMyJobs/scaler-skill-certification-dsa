package tct1.linearstructure.searching;

public class FirstMissingPositiveInteger {
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
