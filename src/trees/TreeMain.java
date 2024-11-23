package trees;

public class TreeMain {

    public static void main(String[] args) {
        int[] a = new int[]{10,15,12,17,3,7,2,9};
        BST bst = new BST();

        bst.populate(a);
        bst.insert(5);
        bst.display();
    }
}
