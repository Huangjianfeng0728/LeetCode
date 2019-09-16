package binaryTree;


public class SubtreeWithMaximumAverage {
    private int subSum=Integer.MIN_VALUE;
    private int subSize=0;
    private TreeNode ret;
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public class ResultType{
        public int sum;
        public int size;
        ResultType(int sum,int size){
            this.size=size;
            this.sum=sum;
        }
    }
    public TreeNode findSubtree2(TreeNode root) {
        if (root==null){
            return null;
        }

        findMinNode(root);
        return ret;
    }
    private ResultType findMinNode(TreeNode node){
        if (node==null){
            return new ResultType(0,0);
        }
        ResultType left=findMinNode(node.left);
        ResultType right=findMinNode(node.right);
        ResultType rootType=new ResultType(left.sum+right.sum+node.val,left.size+right.size+1);
        /*ResultType rootType=new ResultType(findMinNode(node.left).sum+
                            findMinNode(node.right).sum+node.val,findMinNode(node.left).size+findMinNode(node.right).size+1);Overstack*/
        if (rootType.sum*subSize>subSum*rootType.size){
            subSum=rootType.sum;
            subSize=rootType.size;
            ret=node;
        }
        return rootType;
    }
}
