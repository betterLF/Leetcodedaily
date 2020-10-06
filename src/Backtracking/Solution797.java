package Backtracking;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/29-9:05
 */
public class Solution797 {
    /*
      public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    }
     */
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
               ans=new ArrayList<>();
               Stack<Integer> queue=new Stack<>();
               queue.add(0);
               back(queue,graph,0,graph.length-1);
               return ans;
    }
    private void back(Stack<Integer> stack,int [][]graph,int satrt,int target){
        if(satrt==target){
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i <graph[satrt].length ; i++) {
            int cur=graph[satrt][i];
               stack.push(cur);
                back(stack, graph, cur, target);
                stack.pop();
            }
    }
}
