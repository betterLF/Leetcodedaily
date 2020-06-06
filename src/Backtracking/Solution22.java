package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/4-19:03
 */
public class Solution22 {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    List<String> ans;
    StringBuilder stack;
    public List<String> generateParenthesis(int n) {
         ans=new ArrayList<>();
         stack=new StringBuilder();
         back(n,0,0);
         return ans;
    }
    private void back(int n,int leftCount,int RightCount){
        if(leftCount==n&&RightCount==n){//如果左右括号都达到最大值
            ans.add(new String(stack.toString()));
            return;
        }
        if(leftCount==RightCount){//如果左右括号相等
            stack.append('(');
            back(n,leftCount+1,RightCount);
            stack.deleteCharAt(stack.length()-1);//还原
            return;
        }
        if(leftCount==n){//如果左括号到达最大值
            stack.append(')');
            back(n,leftCount,RightCount+1);
            stack.deleteCharAt(stack.length()-1);//还原
            return;
        }
        if(leftCount>RightCount){
            stack.append('(');//当前加入左括号
            back(n,leftCount+1,RightCount);
            stack.deleteCharAt(stack.length()-1);
            stack.append(')');//当前加入右括号
            back(n,leftCount,RightCount+1);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
