package breadthFirstSearch;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

import java.util.*;

public class GraphValidTree {

    private ArrayList<Boolean> marked;
    private int edgesNum=0;
    class Graph{
        HashMap<Integer, Set<Integer>> adj=new HashMap<>();
        public Graph(int[][] edges){
            for (int i=0;i<edges.length;i++){
                if (adj.get(edges[i][0])==null){
                    adj.put(edges[i][0],new HashSet(edges[i][1]));
                }
                adj.get(edges[i][0]).add(edges[i][1]);
                if (adj.get(edges[i][1])==null){
                    adj.put(edges[i][1],new HashSet(edges[i][0]));
                }
                adj.get(edges[i][1]).add(edges[i][0]);
            }
        }
        public int getSize(){
            return adj.size();
        }
    }
    public boolean validTree(int n, int[][] edges) {
        edgesNum=edges.length;
        Graph G=new Graph(edges);
        marked=new ArrayList<>(G.getSize());
        for (int i=0;i<G.getSize();i++){
            marked.add(i,false);
        }
        int s=0;
        bfs(G,s);
        for (boolean m:marked){
            if (!m){
                return false;
            }
        }
        if (edgesNum!=n-1){
            return false;
        }
        return true;
    }
    private void bfs(Graph G,int s){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        if (!marked.isEmpty()){
            marked.set(s,true);
        }
        while(!queue.isEmpty()){
            int node=((LinkedList<Integer>) queue).removeFirst();
            if (G.adj.get(node)==null){
                continue;
            }
            for (int w:G.adj.get(node)){
                if (!marked.get(w)){
                    ((LinkedList<Integer>) queue).addLast(w);
                    marked.set(w,true);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphValidTree gvt=new GraphValidTree();
        int[][] test={{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(gvt.validTree(5,test));

    }

}
