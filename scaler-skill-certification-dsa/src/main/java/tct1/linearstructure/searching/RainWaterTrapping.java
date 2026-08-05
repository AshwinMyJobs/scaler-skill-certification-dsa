package tct1.linearstructure.searching;

public class RainWaterTrapping {
    public static int rainWaterTrapping(int[] A){
        int[] leftMaxArray = new int[A.length];
        leftMaxArray[0] = A[0];
        int[] rightMaxArray = new int[A.length];
        rightMaxArray[A.length-1] = A[A.length-1];
        int leftMax = A[0];
        int rightMax = A[A.length-1];

        for (int i = 1; i < A.length; i++) {
            if(leftMax<A[i]) leftMax = A[i];
            leftMaxArray[i] = leftMax;
        }

        for (int i = A.length-1; i >= 0 ; i--) {
            if(rightMax<A[i]) rightMax = A[i];
            rightMaxArray[i] = rightMax;
        }

        int totalWaterStored = 0;
        for (int i = 0; i < A.length; i++) {
            totalWaterStored += Math.min(leftMaxArray[i],rightMaxArray[i])-A[i];
        }
        return totalWaterStored;
    }
}
