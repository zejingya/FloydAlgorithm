package Search;

public class SeqSearch {
    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
