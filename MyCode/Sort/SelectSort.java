package Sort;

public class SelectSort {

    public static void SelectSort(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];

            for(int j = i + 1;j < array.length;j++){
                if (min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }

            if(minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}
