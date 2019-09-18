package breadthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(boolean[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    bfs(i, j, grid);
                    ret++;
                }
            }
        }
        return ret;
    }
    public void bfs(int x,int y,boolean[][] grid){
        int[] deltaY = {0, 0, -1, 1};
        int[] deltaX = {1, -1, 0, 0};
        Queue<Integer[]> queue=new LinkedList<>();
        queue.offer(new Integer[]{x,y});
        while (!queue.isEmpty()){
            Integer[] root=queue.poll();
            grid[root[0]][root[1]]=false;
            for (int i=0;i<4;i++){
                int newX=root[0]+deltaX[i];
                int newY=root[1]+deltaY[i];
                if (newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                    if (grid[newX][newY]){
                        grid[newX][newY]=false;
                        queue.offer(new Integer[]{newX,newY});
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        NumberOfIslands no=new NumberOfIslands();
        boolean[][] grid={{true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},
                {false,false,false,false,false},{false,false,false,false,true}};
        System.out.println(no.numIslands(grid));
    }
}

