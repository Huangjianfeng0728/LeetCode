package binaryTree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public class ResultType{
        public boolean hasOne;
        public TreeNode ret;
        ResultType(boolean hasOne,TreeNode ret){
            this.hasOne=hasOne;
            this.ret=ret;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        return LCA(root,A,B).ret;
    }
    private ResultType LCA(TreeNode node,TreeNode A,TreeNode B){
        if (node==null){
            return new ResultType(false,null);
        }
        if (node==A){
            return new ResultType(true,A);
        }
        if (node==B){
            return new ResultType(true,B);
        }
        ResultType left=LCA(node.left,A,B);
        ResultType right=LCA(node.right,A,B);
        if (left.hasOne && right.hasOne){
            return new ResultType(true,node);
        }
        if (left.hasOne){
            return new ResultType(true,left.ret);
        }
        if (right.hasOne){
            return new ResultType(true,right.ret);
        }
        return new ResultType(false,null);
    }

}
