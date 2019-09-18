package breadthFirstSearch;

import java.util.*;

public class CloneGraphIncorrect {
     class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
    class Graph{
        HashMap<UndirectedGraphNode,UndirectedGraphNode> marked=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        public Graph(UndirectedGraphNode node){
            queue.add(node);
            while (!queue.isEmpty()){
                int size=queue.size();
                for (int i=0;i<size;i++){
                    UndirectedGraphNode rootDep=queue.poll();
                    UndirectedGraphNode root;
                    if (marked.get(rootDep)!=null){
                        root=marked.get(rootDep);
                    }else {
                        root=new UndirectedGraphNode(rootDep.label);
                    }
                    if (marked.get(rootDep)==null){
                        marked.put(rootDep,root);
                    }
                    for (int j=0;j<rootDep.neighbors.size();j++){
                        UndirectedGraphNode leaf;
                        if (marked.get(rootDep.neighbors.get(j))!=null){
                            leaf=marked.get(rootDep.neighbors.get(j));
                        }else{
                            leaf=new UndirectedGraphNode(rootDep.neighbors.get(j).label);
                            marked.put(rootDep.neighbors.get(j),leaf);
                        }
                        root.neighbors.add(leaf);
                        if (marked.get(rootDep.neighbors.get(j))==null){
                            queue.offer(rootDep.neighbors.get(j));
                            marked.put(rootDep.neighbors.get(j),leaf);
                        }
                    }
                }
            }
        }
        public UndirectedGraphNode getRet(UndirectedGraphNode node){
            return marked.get(node);
        }
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //1,生成node为起始节点的图
        //2,通过循环new出adj中索引所在的节点。
        //3,通过foreach循环遍历new出索引的邻接表的节点
        Graph G=new Graph(node);
        return G.getRet(node);
    }
}
