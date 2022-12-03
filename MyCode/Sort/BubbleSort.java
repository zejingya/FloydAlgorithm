package Sort;

public class BubbleSort {

    public static void BubbleSort(int[] array){

        int t = 0;
        boolean flag = false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0;j < array.length - i;j++){

                if (array[j] > array[j + 1]){
                    flag = true;
                    t = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = t;
                }
            }

            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
