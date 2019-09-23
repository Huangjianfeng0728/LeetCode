package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        if (candidates.length==0){
            return null;
        }
        Arrays.sort(candidates);
        int[] nums=deleteDep(candidates);
        dfs(nums,new ArrayList<Integer>(),0,target,results);
        return results;
    }
    private void dfs(int[] candidates,List<Integer> list,int startIndex,int remainTarget,List<List<Integer>> results){
        if (remainTarget==0){
            //results.add(list);一定不能直接存储list的引用！！！
            results.add(new ArrayList<>(list));
            return;
        }
        if (remainTarget<0){
            return;
        }
        for (int i=startIndex;i<candidates.length;i++){//i=startIndex,避免重复的组合被加入到搜索中
            list.add(candidates[i]);
            //            if(i!=startIndex && candidates[i]==candidates[i-1]){
            //                continue;
            //            }
            //            可以用此取代去重操作
            dfs(candidates,list,i,remainTarget-candidates[i],results);
            list.remove(list.size()-1);
        }
    }
    private int[] deleteDep(int[] candidates){
        int index=0;
        for (int i=0;i<candidates.length;i++){
            if (candidates[i]!=candidates[index]){
                candidates[++index]=candidates[i];
            }
        }
        int[] nums=new int[index+1];
        for (int i=0;i<index+1;i++){
            nums[i]=candidates[i];
        }
        return nums;
    }
}
