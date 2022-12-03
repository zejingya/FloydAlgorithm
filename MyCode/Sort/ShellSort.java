package Sort;

public class ShellSort {
    public static void shellSort(int[] arr){
        int t = 0;
        for (int g = arr.length;g > 0;g /= 2){
            for (int i = 0; i <arr.length ; i++) {
                for (int j = i - g;j >= 0;j -= g){
                    if (arr[j] > arr[j + g]){
                        t = arr[j + g];
                        arr[j + g] = arr[j];
                        arr[j] = t;
                    }
                }
            }
        }
    }
}
