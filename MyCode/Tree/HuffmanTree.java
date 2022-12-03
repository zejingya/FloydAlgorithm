package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static Node createHuffmanTree(int[] arr){

        List<Node> nodes = new ArrayList<>();
        for (int val:
             arr) {
            nodes.add(new Node(val));
        }

        while (nodes.size() > 1){
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);

            Node leftnode = nodes.get(0);
            Node rightnode = nodes.get(1);

            Node parentnode = new Node(leftnode.value + rightnode.value);
            parentnode.left = leftnode;
            parentnode.right = rightnode;

            nodes.remove(leftnode);
            nodes.remove(rightnode);
            nodes.add(parentnode);
        }

        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    int value; // ���Ȩֵ
    char c; //�ַ�
    Node left; // ָ�����ӽ��
    Node right; // ָ�����ӽ��

    public Node(final int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value + '}';
    }

    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if(left != null) {
            left.preOrder();
        }
        if(right != null) {
            right.preOrder();
        }
    }
}
