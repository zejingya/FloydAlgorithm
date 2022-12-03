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
    int value; // 结点权值
    char c; //字符
    Node left; // 指向左子结点
    Node right; // 指向右子结点

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
