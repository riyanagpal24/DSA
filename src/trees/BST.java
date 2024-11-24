package trees;

public class BST {

    private class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,int height) {
            this.val = val;
        }

    }


    Node root;

    public int height(Node node){
        if(node== null){
            return -1;
        }
        return node.height;
    }
    public void insert(int val){
        root = insert(val,root);
    }

    private Node insert(int val, Node root) {
            if (root == null){
                root = new Node(val);
                return root;
            }

            Node current = root;
            while(current!=null){
                if(val<=current.val){
                    if(current.left == null){
                        current.left = new Node(val);
                        break;
                    }else{
                        current = current.left;
                    }
                }else{
                    if(current.right==null){
                        current.right = new Node(val);
                        break;
                    }else{
                        current = current.right;
                    }
                }
            }

            return root;
        }


    private Node insertRec(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.val) {
            node.left = insert(value, node.left);
        }

        if (value > node.val) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }



    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.val);
        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void preOrder(){
        if(root == null){
            System.out.println("The tree is empty");
            return;
        }
        System.out.print("PreOrder: ");
        preOrder(root);
        System.out.println("END");
    }

    private void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(" " +root.val + "---->");
        preOrder(root.left);
        preOrder(root.right);
    }


    public void postOrder(){
        if(root == null){
            System.out.println("The tree is empty");
            return;
        }
        System.out.print("PostOrder:");
        postOrder(root);
        System.out.println("END");
    }

    private void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " +root.val + "---->");
    }

    public void inOrder(){
        if(root == null){
            System.out.println("The tree is empty");
            return;
        }
        System.out.print("InOrder:");
        inOrder(root);
        System.out.println("END");
    }

    private void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(" " +root.val + "---->");
        inOrder(root.right);
    }

}
