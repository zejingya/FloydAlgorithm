package Algorithm.DivideandConquer;

public class Hanoitower {

    public static void hanoiTower(int num, char a, char b, char c){

        if (num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {

            hanoiTower(num - 1,a,b,c);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
