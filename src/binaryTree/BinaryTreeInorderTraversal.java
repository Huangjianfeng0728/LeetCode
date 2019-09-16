package binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }
    private void inorderTraversal(TreeNode node, List list){
        if (node==null){
            return;
        }
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);
    }
    /**
     * 非递归版本:用栈的特性模拟递归调用
     */
    public List<Integer> inorderTraversalNocurrsion(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        while (!stack.isEmpty()){
            TreeNode node=stack.peek();
            ret.add(node.val);
            if (node.right==null){
                node=stack.pop();
                while(!stack.isEmpty() && stack.peek().right==node){
                    node=stack.pop();
                }
            }else {
                node=node.right;
                while(node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
        }
        return ret;
    }
}
