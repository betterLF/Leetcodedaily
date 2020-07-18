package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/7/16-6:30
 */
public class Solution401 {
    /*
    二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
     */
    public List<String> ans;
    public List<String> readBinaryWatch(int num) {
       ans=new ArrayList<>();
       Stack<Integer> stack=new Stack<>();
       dfs(num,stack);
       return ans;
    }
    private  void dfs(int loss, Stack<Integer> stack){
        if(stack.size()==10){
            if(loss==0) {
                add(stack);
            }
            return;
        }
        if(loss==0){
            stack.push(0);
            dfs(loss,stack);
            stack.pop();
        }
        if(loss>0&&10-stack.size()>=loss) {
            stack.push(0);
            dfs(loss, stack);
            stack.pop();
        }
        if(loss>0){
            stack.push(1);
            dfs(loss-1,stack);
            stack.pop();
        }
    }
    private void add(Stack<Integer> stack){
             int hour=0;
             int minute=0;
        for (int i = 0; i <4 ; i++) {
            hour+=stack.get(i)*(int)Math.pow(2,3-i);
        }
        if(hour>=12){
            return;
        }
        for (int i = 4; i <10 ; i++) {
            minute+=stack.get(i)*(int)Math.pow(2,9-i);
        }
          if(minute>=60){
              return;
          }
          StringBuilder curAns=new StringBuilder();
          curAns.append(hour).append(":");
          if(minute<10){
              curAns.append("0");
          }
          curAns.append(minute);
          ans.add(curAns.toString());
    }
}
