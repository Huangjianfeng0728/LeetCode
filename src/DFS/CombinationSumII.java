package DFS;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>>  results = new ArrayList<>();
        //1,Sort
        Arrays.sort(num);
        //2.DFS进行遍历，获取符合条件的组合
        dfs(num,new ArrayList<>(),results,target,0);
        return results;
    }
    private void dfs(int[] num , List<Integer> result , List<List<Integer>> results , int remainTarget , int startIndex){
        if (remainTarget == 0){
            results.add(new ArrayList<>(result));
            return;
        }
        if (remainTarget < 0){
            return;
        }
        for(int i = startIndex ; i < num.length ; i++){

           if (i!=startIndex && num[i]==num[i-1]){
               continue;
           }
           //[1,1,6],[1’,2,5],[1'',2,5]，[1,7],result中索引相同的数字出现在同一层的循环中。即7和1,2在同一层循环中。
            // 因此1' 与 1''为同一层循环的两个值，1’=num[startIndex],i''=num[startIndex+1]
            result.add(num[i]);
            dfs(num,result,results,remainTarget-num[i],i+1);
            result.remove(result.size()-1);
        }
    }
}
