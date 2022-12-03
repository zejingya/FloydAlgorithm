package HashTab;

import java.util.Scanner;

public class HashTabdemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }


    public int hashFun(int id) {
        return id % size;
    }

}
    class Emp {//雇员
        public int id;
        public String name;
        public Emp next;
        public Emp(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }

    class EmpLinkedList{
        private Emp head;

        public void add(Emp emp){
            if (head == null){
                head = emp;
                return;
            }
            Emp curEmp = head;
            while (true){
                if (curEmp.next == null){
                    break;
                }
                curEmp = curEmp.next;
            }
            curEmp.next = emp;
        }

        public void list(int no){
            if (head == null){
                System.out.println("kong");
                return;
            }
            Emp curEmp = head;
            while (true){
                System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null){
                    break;
                }
                curEmp = curEmp.next;
            }
            System.out.println();
        }

        public Emp findEmpById(int id){
            if(head == null) {
                System.out.println("链表为空");
                return null;
            }
            Emp curEmp = head;
            while (true){
                if (curEmp.id == id){
                    break;
                }
                if(curEmp.next == null) {
                    curEmp = null;
                    break;
                }
                curEmp = curEmp.next;
            }
            return curEmp;
        }
    }
