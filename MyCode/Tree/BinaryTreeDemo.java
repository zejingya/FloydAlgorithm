package Tree;

public class BinaryTreeDemo {

    class BinaryTree{
        private HeroNode root;

        public void setRoot(final HeroNode root) {
            this.root = root;
        }

        public void delNode(int no){
            if (root == null){
                System.out.println("空");
                return;
            }
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }

        //这里对于三个遍历方法进行了重写，不明白为什么（印象中是未来调用方便）我懒得重写了
        public HeroNode preOrderSearch(int no){
            if (root == null){
                return null;
            }else {
               return root.preOrderSearch(no);
            }
        }
        public HeroNode infixOrderSearch(int no) {
            if(root != null) {
                return root.infixOrderSearch(no);
            }else {
                return null;
            }
        }
        public HeroNode postOrderSearch(int no) {
            if(root != null) {
                return root.postOrderSearch(no);
            }else {
                return null;
            }
        }
    }

    class HeroNode{

        private int no;
        private String name;
        private HeroNode left;
        private HeroNode right;

        public HeroNode(final int no, final String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return this.no;
        }

        public String getName() {
            return this.name;
        }

        public HeroNode getLeft() {
            return this.left;
        }

        public HeroNode getRight() {
            return this.right;
        }

        public void setNo(final int no) {
            this.no = no;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setLeft(final HeroNode left) {
            this.left = left;
        }

        public void setRight(final HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        public void delNode(int no){//有点问题
            if (left != null && left.no == no){
                left = null;
                return;
            }
            if (right != null && right.no == no){
                right = null;
                return;
            }
            if(this.left != null) {
                this.left.delNode(no);
            }
            if(this.right != null) {
                this.right.delNode(no);
            }
        }

        public void preOrder(){
            System.out.println(this);
            if (left != null){
                left.preOrder();
            }
            if (right != null){
                right.preOrder();
            }
        }
        public void infixOrder() {

            if(left != null) {
                left.infixOrder();
            }
            System.out.println(this);
            if(right != null) {
                right.infixOrder();
            }
        }
        public void postOrder() {
            if(this.left != null) {
                this.left.postOrder();
            }
            if(this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        public HeroNode preOrderSearch(int no){

            if (this.no == no){
                return this;
            }
            HeroNode resNode = null;
            if (left != null){
                resNode = left.preOrderSearch(no);
            }
            if (resNode != null){
                return resNode;
            }
            if (right != null){
                resNode = right.preOrderSearch(no);
            }
            return resNode;
        }
        public HeroNode infixOrderSearch(int no){
            HeroNode resNode = null;
            if (left != null){
                resNode = left.infixOrderSearch(no);
            }
            if (resNode != null){
                return resNode;
            }
            if (this.no == no){
                return this;
            }
            if (right != null){
                resNode = right.infixOrderSearch(no);
            }
            return resNode;
        }
        public HeroNode postOrderSearch(int no){
            HeroNode resNode = null;
            if (left != null){
                resNode = left.postOrderSearch(no);
            }
            if (resNode != null){
                return resNode;
            }
            if (right != null){
                resNode = right.postOrderSearch(no);
            }
            if (resNode != null){
                return resNode;
            }
            if (this.no == no){
                return this;
            }
            return resNode;
        }
    }
}
