package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/20-8:19
 */
public class Solution0809ms {
    /*
    括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
说明：解集不能包含重复的子集。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
     */
     public List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int countLeft=1;
        int countRight=0;
        StringBuilder cur=new StringBuilder();
        cur.append("(");
        DFS(cur,countLeft,countRight,n);
        return res;
    }
    private void DFS(StringBuilder cur,int countLeft,int countRight,int n){
            if(countLeft>countRight){//剪枝
                //左括号递归
                if(countLeft<n) {
                    countLeft++;
                    cur.append("(");
                    int num = cur.length();
                    DFS(cur, countLeft, countRight, n);
                    if (countLeft == n && countRight == n) {
                        res.add(cur.toString());
                    }
                    cur.deleteCharAt(num - 1);
                    countLeft--;
                }
                //右括号递归
                if(countRight<n) {
                    countRight++;
                    cur.append(")");
                  int  num = cur.length();
                    DFS(cur, countLeft, countRight, n);
                    if (countLeft == n && countRight == n) {
                        res.add(cur.toString());
                    }
                    cur.deleteCharAt(num - 1);
                    countRight--;
                }
            }else{
                countLeft++;
                cur.append("(");
                int num=cur.length();
                DFS(cur,countLeft,countRight,n);
                if(countLeft==n&&countRight==n){
                    res.add(cur.toString());
                }
                cur.deleteCharAt(num-1);
            }
        }

    }

