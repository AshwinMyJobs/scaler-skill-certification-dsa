package tct1.linearstructure.searching;

public class EqulibriumIndex {

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
