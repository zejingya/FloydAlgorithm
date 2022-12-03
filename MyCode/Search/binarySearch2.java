package Search;

import java.util.ArrayList;
import java.util.List;

public class binarySearch2 {
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){

        if (left > right){
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midvalue = arr[mid];

        if (findVal > midvalue){
           return binarySearch2(arr,mid + 1,right,findVal);
        }else if (findVal < midvalue){
           return binarySearch2(arr,left,mid - 1,findVal);
        }else {

            List<Integer> resIndexlist = new ArrayList<Integer>();

            int t = mid - 1;
            while (true){
                if (t == 0 || arr[t] != findVal){
                    break;
                }
                resIndexlist.add(t--);
            }

            resIndexlist.add(mid);

            t = mid + 1;
            while (true){
                if (t > arr.length - 1 || arr[t] != findVal){
                    break;
                }
                resIndexlist.add(t++);
            }

            return resIndexlist;
        }

    }
}
