package String;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/5/19-7:40
 */
public class Solution856 {
    /*
    给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。
     */
    public int scoreOfParentheses(String S) {
            int ans = 0, bal = 0;
            for (int i = 0; i < S.length(); ++i) {
                if (S.charAt(i) == '(') {
                    bal++;
                } else {
                    bal--;
                    if (S.charAt(i-1) == '(')
                        ans += 1 << bal;
                }
            }

            return ans;
        }
    public int scoreOfParentheses2(String S) {
        int score = 0;
        int length = S.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<length; i++){
            char temp = S.charAt(i);
            if(temp=='(')
                stack.add(temp);
            else{
                if(S.charAt(i-1)=='('){
                    score += Math.pow(2, stack.size()-1);
                    stack.pop();
                }else{
                    stack.pop();
                }
            }

        }

        return score;
    }


}
