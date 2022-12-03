package Sort;

public class RadixSort {
    public static void radixsort(int[] array){

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][array.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n = 0;i < maxLength;i++,n *= 10){
            for (int j = 0;j < array.length;j++){

                int digitOfElement = array[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = array[j];
            }

            int index = 0;
            for (int m = 0;m < bucketElementCounts.length;m++){
                if (bucketElementCounts[m] != 0){
                    for (int k = 0; k < bucketElementCounts[m];k++){

                        array[index++] = bucket[m][k];
                    }
                }
                bucketElementCounts[m] = 0;
            }
        }

    }
}
