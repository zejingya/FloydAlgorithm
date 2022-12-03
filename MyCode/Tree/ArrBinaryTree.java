package Tree;

public class ArrBinaryTree {

    private int[] arr;
    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }
        System.out.println(arr[index]);
        if (arr[index * 2 + 1] < arr.length){
            preOrder(index * 2 + 1);
        }
        if (arr[index * 2 + 2] < arr.length){
            preOrder(index * 2 + 2);
        }
    }
}
