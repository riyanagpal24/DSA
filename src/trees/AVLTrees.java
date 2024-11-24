package trees;

public class AVLTrees {


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
        root = insertRec(val,root);
    }


    private Node insertRec(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.val) {
            node.left = insertRec(value, node.left);
        }

        if (value > node.val) {
            node.right = insertRec(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }


    public Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            // left heavy -> unbalanced node is on the left tree
            if(height(node.left.left)-height(node.left.right)>0){
               return rotateRight(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //left-right case
                node.left  =  rotateLeft(node.left);
                return rotateRight(node);
            }
        }else if(height(node.right)-height(node.left)>1){
            if(height(node.right.right)-height(node.right.left)>0){
                return rotateLeft(node);
            }
            if(height(node.right.right)-height(node.right.left)<0){
                //left-right case
                node.right  =  rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }


    public Node rotateLeft(Node node){
        Node parent = node;
        Node child = parent.right;
        Node left = child.left;
        child.left = parent;
        parent.right = left;

        parent.height = Math.max(height(parent.left),height(parent.right))+1;
        child.height = Math.max(height(child.left),height(child.right))+1;
        return child;
    }

    public Node rotateRight(Node node){

        Node parent = node;
        Node child = parent.left;
        Node right = child.right;
        child.right = parent;
        parent.left = right;

        parent.height = Math.max(height(parent.left),height(parent.right))+1;
        child.height = Math.max(height(child.left),height(child.right))+1;
        return child;
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
}
