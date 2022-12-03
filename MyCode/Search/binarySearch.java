package Search;

public class binarySearch {
    public int binarysearch(int[] array,int left,int right,int find){

        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midvalue = array[mid];
        if(find > midvalue){
            return binarysearch(array,mid + 1,right,find);
        }else if (find < midvalue){
            return binarysearch(array,0,mid - 1,find);
        }else {
            return mid;
        }

    }
}
