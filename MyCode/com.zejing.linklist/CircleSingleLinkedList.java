package com.zejing.linklist;

public class CircleSingleLinkedList {
    private Boy first = null;

    public CircleSingleLinkedList() {
    }

    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("错");
        }else{
            Boy tboy = null;
            for (int i = 1; i <= nums; i++) {
                Boy boy = new Boy(i);
                if(i == 1){
                    first = boy;
                    first.setNext(first);
                    tboy = first;
                }else {
                    tboy.setNext(boy);
                    boy.setNext(first);
                    tboy = boy;
                }
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("无");
        }else {
            Boy tboy;
            for (tboy = first;tboy.getNext() == first;tboy = tboy.getNext()){
                System.out.println(tboy.getNo());
            }
        }
    }

    public void countBoy(int k, int m, int nums){
        if (first != null && k >= 1 && k <= nums){
            Boy temp;
            for(temp = first;temp.getNext() != first;temp = temp.getNext()){}

            for(int i = 0; i < k -1;i++){
                first = first.getNext();
                temp = temp.getNext();
            }

            while (temp.getNext() != first){
                for(int i = 0;i < m - 1;i++){
                    first = first.getNext();
                    temp = temp.getNext();
                }
                System.out.printf("小孩%d出圈\n", this.first.getNo());
                first = first.getNext();
                temp.setNext(first);
            }

            System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getNo());

        } else {
            System.out.println("错");
        }
    }
}

