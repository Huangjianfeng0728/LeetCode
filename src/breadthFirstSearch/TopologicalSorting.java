package breadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result=new ArrayList<>();
        HashMap<DirectedGraphNode,Integer> map=new HashMap<>();
        for ( DirectedGraphNode node:graph){
            for (DirectedGraphNode neighbor:node.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor,1);
                }else{
                    map.put(neighbor,map.get(neighbor)+1);
                }
            }
        }
        Queue<DirectedGraphNode> queue=new LinkedList<>();
        for (DirectedGraphNode node:graph){
            if (!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        while (!queue.isEmpty()){
            DirectedGraphNode root=queue.poll();
            for (DirectedGraphNode neighbor:root.neighbors){
                if (map.get(neighbor)==1){
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
                map.put(neighbor,map.get(neighbor)-1);
            }
        }
        return result;
    }
}
