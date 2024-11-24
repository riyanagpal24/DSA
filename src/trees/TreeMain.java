package trees;

import java.util.ArrayList;

public class TreeMain {

    public static void main(String[] args) {
        int[] a = new int[]{10,15,12,17,3,7,2,9};
        BST bst = new BST();

       /* bst.populate(a);
        bst.insert(5);
        bst.display();*/

        /*int[] b = new int[]{10,5,20,3,8,2};
        BST tree2 = new BST();
        tree2.populate(b);
        tree2.display();
        tree2.preOrder();
        tree2.postOrder();
        tree2.inOrder();*/

        int[] b = new int[]{1,2,3,4,5};
        AVLTrees tree2 = new AVLTrees();
        tree2.populate(b);
        tree2.display();

    }
}
