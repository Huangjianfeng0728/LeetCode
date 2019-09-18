package breadthFirstSearch;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        ((LinkedList<TreeNode>) queue).addLast(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode head=((LinkedList<TreeNode>) queue).removeFirst();
                list.add(head.val);
                if (head.left!=null){
                    ((LinkedList<TreeNode>) queue).addLast(head.left);
                }
                if (head.right!=null){
                    ((LinkedList<TreeNode>) queue).addLast(head.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
