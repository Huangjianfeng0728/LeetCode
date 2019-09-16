package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList();
        if (root==null){
            return list;
        }
        binaryTreePaths(root,String.valueOf(root.val),list);
        return list;

    }
    private void binaryTreePaths(TreeNode node,String path,List<String> list){
        if (node==null){
            return;
        }
        if (node.left==null && node.right==null){
            list.add(path);
        }
        if (node.left!=null){
            binaryTreePaths(node.left,path+"->"+node.left.val,list);
        }
        if (node.right!=null){
            binaryTreePaths(node.right,path+"->"+node.right.val,list);
        }

    }
    //Devide Conquer
    public List<String> binaryTreePaths1(TreeNode root){
        List<String> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        List<String> left=binaryTreePaths1(root.left);
        List<String> right=binaryTreePaths1(root.right);
        for (String path:left){
            list.add(root.val+"->"+path);
        }
        for (String path:right){
            list.add(root.val+"->"+path);
        }
        if (list.size()==0){
            list.add(""+root.val);
        }
        return list;
    }
}
