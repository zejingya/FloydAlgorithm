package com.zejing.linklist;

public class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;

    public Node(int no, String name,  String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
