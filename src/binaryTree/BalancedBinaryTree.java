package binaryTree;

public class BalancedBinaryTree {
    private int depthDiffer;
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        depth(root);
        return depthDiffer==0;
    }
    private int depth(TreeNode node){
        if (node==null){
            return 0;
        }
        int depth=Math.max(depth(node.left),depth(node.right))+1;
        if (Math.abs(depth(node.left)-depth(node.right))>1){
            depthDiffer=Math.abs(depth(node.left)-depth(node.right));
        }
        return depth;
    }
}
