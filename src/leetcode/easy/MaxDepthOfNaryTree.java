package leetcode.easy;

import java.util.List;

public class MaxDepthOfNaryTree {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        int max = 0;
        public int maxDepth(Node root) {

            if(root==null)
                return 0;

            help(root);
            return max+1;
        }


        private void help(Node root){
            int curr = 0;
            if(root == null){
                return;
            }

            if(root.children.size()>0){
                curr++;
                max = Math.max(max, curr);
                for(Node n : root.children){
                    help(n);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
