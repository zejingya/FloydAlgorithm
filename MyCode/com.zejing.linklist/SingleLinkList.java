package com.zejing.linklist;

public class SingleLinkList  {
        private Node head = new Node(0,"","");

        public SingleLinkList() {
        }

        public Node getHead(){return head;}

        public void add(Node node){
                Node t;
                for (t= head;t.next != null;t = t.next) {
                }
                t.next = node;
        }

        public void addByOrder(Node node){

                Node t;
                boolean flag;
                for (flag = false,t = head;t.next != null && t.next.no <= node.no;t = t.next){
                        if(t.next.no == node.no){
                                flag = true;
                                break;
                        }
                }
                if(flag){
                        System.out.println("存在");
                }else {
                        node.next = t.next;
                        t.next = node;
                }
        }

        public void update(Node newNode){

                if(null == head.next){
                        System.out.println("空");
                }else {
                       Node t = head.next;
                        boolean flag;
                        for(flag = false;t != null;t = t.next){
                                if(t.no == newNode.no){
                                        flag = true;
                                        break;
                                }
                        }
                        if(flag){
                           t.name = newNode.name;
                           t.nickname = newNode.nickname;
                        }else {
                                System.out.println("無");
                        }
                }
        }
        public void del(int no){

                Node t = head;
                boolean flag;

                for (flag = false;t.next != null;t = t.next){
                        if(t.next.no == no){
                                flag = true;
                                break;
                        }
                }
                if(flag){
                        t.next = t.next.next;
                }else {
                        System.out.println("無");
                }

        }
        public void list(){
                if(head.next == null){
                        System.out.println("無");
                }else {
                        for (Node t = head.next;t.next != null;t = t.next){
                                System.out.println(t);
                        }
                }
        }
}
