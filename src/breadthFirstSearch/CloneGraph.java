package breadthFirstSearch;

import java.util.*;

public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null){
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes=getNodes(node);
        //COPY NODE
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        for (UndirectedGraphNode n:nodes){
            map.put(n,new UndirectedGraphNode(n.label));
        }
        for (UndirectedGraphNode n:nodes){
            for (UndirectedGraphNode m:n.neighbors){
                map.get(n).neighbors.add(map.get(m));
            }
        }
        return map.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        HashSet<UndirectedGraphNode> set=new HashSet<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode root=queue.poll();
            for (UndirectedGraphNode n:root.neighbors){
                if (!set.contains(n)){
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
