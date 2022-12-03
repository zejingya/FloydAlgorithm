package com.zejing.linklist;

public class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return this.next;
    }

    public void setNext(Boy next) {
       this.next = next;
    }
}
