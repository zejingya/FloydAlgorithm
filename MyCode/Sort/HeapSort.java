package Sort;

public class HeapSort {

    public static void heapSort(int arr[]){
        int temp = 0;

        for (int i = arr.length - 1;i >= 0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length;j > 0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    public  static void adjustHeap(int arr[], int i, int lenght){
        int t = arr[i];

        for (int j = i * 2 + 1;j < lenght;j = j * 2 + 1){
            if (j + 1 < lenght && arr[j] < arr[j + 1]){
                j++;
            }
            if (arr[j] > t){
                arr[i] = arr[j];//这有点问题,感觉应该是t = arr[j]
                i = j;
            }else {
                break;
            }
        }

        arr[i] = t;
    }
}
