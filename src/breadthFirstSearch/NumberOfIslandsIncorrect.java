package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsIncorrect {
    public int numIslands(boolean[][] grid) {
        int ret=0;
        int[] deltaY={0,0,-1,1};
        int[] deltaX={1,-1,0,0};
        ArrayList<Integer[]> marked=new ArrayList<>();//数组不宜作为hashmap的键，因为数组比较时会比较其内存地址是否相等
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]){
                    marked.add(new Integer[]{i,j});
                }
            }
        }
        Queue<Integer[]> queue=new LinkedList<>();
        queue.offer(marked.remove(0));
        while (!queue.isEmpty()){
            Integer[] root=queue.poll();
            for (int i=0;i<4;i++){
                int x=root[0]+deltaX[i];
                int y=root[1]+deltaY[i];
                if (x>=0 && x<grid.length && y>=0 && y<grid[0].length){
                    if (grid[x][y]){
                        if (marked.contains(new Integer[]{x,y})){
                            marked.remove(new Integer[]{x,y});
                            queue.offer(new Integer[]{x,y});
                        }
                    }
                }
            }
            if (queue.isEmpty()){
                ret++;
                if (!marked.isEmpty()){
                    queue.offer(marked.remove(0));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOfIslandsIncorrect no=new NumberOfIslandsIncorrect();
        boolean[][] grid={{true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},
                {false,false,false,false,false},{false,false,false,false,true}};
        no.numIslands(grid);
        }
}
