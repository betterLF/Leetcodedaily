import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class Solution39 {
    /*
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
     */
   public  List<List<Integer>> res=new LinkedList<>();
    public  int len;
    public   List<List<Integer>> combinationSum(int[] candidates, int target) {
        len=candidates.length;
        Arrays.sort(candidates);
        dfs(new Stack<Integer>(),0,target,candidates);
        return res;
    }
    private  void dfs(Stack<Integer> stack, int i, int t,int candidates[]){
        if(t==0){
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for(int k=i;k<len;k++){
            if(t-candidates[i]<0){
                break;
            }
            stack.push(candidates[k]);
            dfs(stack,k,t-candidates[k],candidates);
            stack.pop();
        }
    }
}
