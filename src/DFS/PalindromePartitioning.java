package DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results=new ArrayList<>();
        dfs(results,s,new ArrayList<String>(),0);
        return results;
    }
    private void dfs(List<List<String>> results,String s,List<String> result,int startIndex){
        if (startIndex == s.length()){
            results.add(result);
        }
        for (int i = startIndex ; i < s.length() ; i++){
            String ss=s.substring(startIndex,i+1);
            if (!isPalindrome(ss)){
                continue;
            }
            result.add(ss);
            dfs(results,s,result,i+1);
            result.remove(result.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        if (s.length()==1){
            return true;
        }
        if (s.length() == 2 && s.charAt(0) == s.charAt(-1)){
            return true;
        }
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
