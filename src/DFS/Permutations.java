package DFS;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        dfs(results,nums,new ArrayList<Integer>(),new boolean[nums.length]);
        return results;
    }
    private void dfs(List<List<Integer>> results , int[] nums , ArrayList<Integer> result ,boolean[] visited ){
        if (result.size() == nums.length){
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0 ; i < nums.length ; i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            dfs(results , nums , result , visited);
            visited[i] = false;
            result.remove(result.size() - 1);//通过画递归图理解
        }
    }
}
