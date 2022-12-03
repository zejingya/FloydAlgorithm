package BinarySortTree;

public class BinarySortTreeDemo {

    class BinarySortTree{
        private Node root;

        public Node getRoot() {
            return this.root;
        }

        public void infixOrder() {
            if(root != null) {
                root.infixOrder();
            } else {
                System.out.println("二叉排序树为空，不能遍历");
            }
        }

        public void add(Node node) {
            if(root == null) {
                root = node;
            } else {
                root.add(node);
            }
        }

        public Node search(int value) {
            if(root == null) {
                return null;
            } else {
                return root.search(value);
            }
        }

        public Node searchParent(int value) {
            if(root == null) {
                return null;
            } else {
                return root.searchParent(value);
            }
        }

        public int delRightTreeMin(Node node){
            Node target = node;

            while (target.left != null){
                target = target.left;
            }

            delNode(target.value);
            return target.value;
        }

        private void delNode(int value) {

            if (root == null){
            }else {
                Node targetNode = search(value);

                if (targetNode == null){
                    return;
                }

                if (root.left == null && root.right == null){
                    root = null;
                    return;
                }

                Node parent = searchParent(value);

                if (targetNode.left == null && targetNode.right == null){

                    if (parent.left.value == value){
                        parent.left = null;
                    }else {
                        parent.right = null;
                    }

                }else if (targetNode.left != null && targetNode.right != null){

                    int minVal = delRightTreeMin(targetNode.right);
                    targetNode.value = minVal;

                }else {

                    if (targetNode.left != null){
                        if (parent != null){

                            if(parent.left.value == value) {
                                parent.left = targetNode.left;
                            } else {
                                parent.right = targetNode.left;
                            }
                        }else {
                            root = targetNode.left;
                        }
                    }else {

                        if(parent != null) {
                            if(parent.left.value == value) {
                                parent.left = targetNode.right;
                            } else {
                                parent.right = targetNode.right;
                            }
                        } else {
                            root = targetNode.right;
                        }
                    }

                }
            }

        }
    }

    class Node{
        int value;
        Node left;
        Node right;

        public Node(final int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public void infixOrder() {
            if(this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if(this.right != null) {
                this.right.infixOrder();
            }
        }

        public void add(Node node){

            if (node == null){
                return;
            }

            if (node.value < value){

                if (left == null){
                    left = node;
                }else {
                    left.add(node);
                }
            }else {
                if (right == null){
                    right = node;
                }else {
                    right.add(node);
                }
            }

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

            if (left != null && left.value == value || right != null && right.value == value){
                return this;
            }else {
                if (value < this.value && left != null){
                   return left.searchParent(value);
                }else if (value > this.value && right != null){
                   return right.searchParent(value);
                }else {
                    return null;
                }
            }
        }

    }
}
