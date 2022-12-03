package com.zejing.recursion;

public class queens {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;


    private void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judge(n)){
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || (Math.abs(n -i) == Math.abs(array[n] - array[i]))){
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] +" ");
        }


    }
}
