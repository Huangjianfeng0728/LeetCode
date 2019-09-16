package binaryTree;

import java.util.HashMap;

public class MinimumSubtree {
    private int subTreeSum=Integer.MAX_VALUE;
    private TreeNode ret;
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public TreeNode findSubtree(TreeNode root) {
        if (root==null){
            return null;
        }
        findSumMin(root);
        return ret;
    }
    private int findSumMin(TreeNode node){
        if (node==null){
            return 0;
        }
        int sum=findSumMin(node.left)+findSumMin(node.right)+node.val;
        if (sum<subTreeSum){
            subTreeSum=sum;
            ret=node;
        }
        return sum;
    }

}
