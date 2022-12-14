package Search;

public class InsertValueSearch {
    public static int  inserstvaluesearch(int[] arr, int left, int right, int findVal){

        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return inserstvaluesearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return inserstvaluesearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
