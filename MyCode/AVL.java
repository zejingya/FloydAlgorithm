public class AVL {

}

class AVLTree{

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node){

        Node target = node;

        while (target.getLeft() != null){
                target = target.getLeft();
        }

        delNode(target.getValue());
        return target.getValue();
    }

    private void delNode(int value) {

        if (root == null) {
            return;
        }else {

            Node targetNode = search(value);

            if (targetNode == null) {
                return;
            }

            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }

            Node parent = searchParent(value);

            if (targetNode.getLeft() == null && targetNode.getRight() == null){

                if (parent.getLeft() != null && parent.getLeft().getValue() == targetNode.getValue()){
                    parent.setLeft(null);
                }else if (parent.getRight() != null && parent.getRight().getValue() == targetNode.getValue()){
                    parent.setRight(null);
                }
            }else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
                int minVal = delRightTreeMin(targetNode.getRight());
                targetNode.setValue(minVal);
            }else {
                if (targetNode.getLeft() != null) {
                    if (parent != null) {
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getLeft());
                        } else {
                            parent.setRight(targetNode.getLeft());
                        }
                    } else {
                        root = targetNode.getLeft();
                    }
                } else {
                    if (parent != null) {
                        if (parent.getLeft().getValue() == value) {
                            parent.setLeft(targetNode.getRight());
                        } else {
                            parent.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }
            }
        }
    }
}

class Node{

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    private void leftRotate(){

        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;

    }

    private void rightRotate(){

        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        right = newNode;
        left = left.left;

    }

    public Node search(int value){

        if (value == this.value){
            return this;
        }else if (value < this.value){
            if (left == null){
                return null;
            }
            return left.search(value);
        }else {
            if (right == null){
                return null;
            }
            return right.search(value);
        }
    }

    public Node searchParent(int value){

        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {

            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }

        }
    }

    public void add(Node node) {

        if (node == null) {
            return;
        }

        if (node.value < value) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }

        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }

        if (rightHeight() - leftHeight() > 1){
            if (right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
        }
    }
}
