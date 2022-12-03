package com.zejing.array;

public class CircleArray {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
    }

    public boolean isFull(){
        return (this.rear + 1) % this.maxSize == this.front;
    }

    public boolean isEmpty(){
        return  rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
        }else {

            arr[rear] = n;
            rear = (rear + 1) % maxSize;

        }
    }

    public int getQueue(){

        if (isEmpty()){
            throw new RuntimeException("kon");
        }else {
            int v = arr[front];
            front = (front + 1) % maxSize;
            return  v;
        }
    }

    public void showQueue(){

      if(isFull()){
          System.out.println("空");
      }else {
          for (int i = front; i < front + size(); i++) {
              System.out.printf("arr[%d]=%d\n", i % this.maxSize, this.arr[i % this.maxSize]);
          }
      }

    }

    public int size(){return (this.rear + this.maxSize - this.front) % this.maxSize;}

    public int headQueue(){
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return this.arr[this.front];
        }
    }
}



