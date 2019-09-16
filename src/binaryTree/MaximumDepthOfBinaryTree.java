package binaryTree;

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    //Devide Conquer
    public int maxDepth(TreeNode root) {
        int h=0;
        return depth(root,h);
    }
    private int depth(TreeNode node,int height){
        if (node==null){
            return 0;
        }
        height=Math.max(depth(node.left,height),depth(node.right,height))+1;
        return height;
    }
    //Traverse
    private int h=0;
    public int maxDepth2(TreeNode root){

        maxTraverse(root,1);
        return h;
    }
    private void maxTraverse(TreeNode root,int curh){
        if (root==null){
            return;
        }
        if (curh>h){
            h=curh;
        }
        maxTraverse(root.left,curh+1);
        maxTraverse(root.right,curh+1);
    }

}
