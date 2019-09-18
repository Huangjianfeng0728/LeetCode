package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public String serialize(TreeNode root) {
        if(root==null){
            return "{}";
        }
        StringBuilder string=new StringBuilder();
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(root);
        for (int i=0;i<queue.size();i++){
            TreeNode node=(queue).get(i);
            if (node==null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (queue.get(queue.size()-1)==null){
            queue.remove(queue.size()-1);
        }
        string.append("{");
        string.append(queue.get(0).val);
        for (int i=1;i<queue.size();i++){
            if (queue.get(i)==null){
                string.append(",#");
            }else {
                string.append(",");
                string.append(queue.get(i).val);
            }
        }
        string.append("}");
        return string.toString();
    }
    public TreeNode deserialize(String data) {
        //使用链表进行需要进行任意位置查询操作时，时间复杂度为O（n）不太好。应该使用数组O（1）时间复杂度。
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if (data.equals("{}")){
            return null;
        }
        boolean isLeft=true;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        ((LinkedList<TreeNode>) queue).addLast(root);
        int index=0;
        for (int i=1;i<nodes.length;i++){
            if (!nodes[i].equals("#")){
                TreeNode node=new TreeNode(Integer.parseInt(nodes[i]));
                if (isLeft){
                    ((LinkedList<TreeNode>) queue).get(index).left=node;
                }else {
                    ((LinkedList<TreeNode>) queue).get(index).right=node;
                }
                ((LinkedList<TreeNode>) queue).addLast(node);
            }
            if (!isLeft){
                index++;
            }
            isLeft=!isLeft;
        }
        return root;
    }
}
