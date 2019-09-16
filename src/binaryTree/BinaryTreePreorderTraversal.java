package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
      public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
     }

    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorderTraversal(root,list);
        return list;
    }
    private void preorderTraversal(TreeNode node,List list){
        if (node==null){
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left,list);
        preorderTraversal(node.right,list);
    }
    /**
     * 非递归版本
     */
    public List<Integer> preorderTraversalNocurrsion(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node!=null){
                ret.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return ret;
    }
}
