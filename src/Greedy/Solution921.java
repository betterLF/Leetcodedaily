package Greedy;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/8-7:38
 */
public class Solution921 {
    /*
给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
它是一个空字符串，或者
它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
它可以被写作 (A)，其中 A 是有效字符串。
给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
     */
    //用栈
    public int minAddToMakeValid(String S) {
        Stack<Character>  s=new Stack<>();
        int len=S.length();
        for (int i = 0; i <len ; i++) {
            if (s.size() != 0 && s.peek() == '(' && S.charAt(i) == ')') {
                s.pop();
            } else {
                s.push(S.charAt(i));
            }
        }
//         int count=0;
//         while(s.size()!=0){
//              s.pop();
//              count++;
//         }
//         return count;
        return s.size();
        }
        //不用栈
        public int minAddToMakeValid2(String S) {
            int len=S.length();
            int l=0;
            int r=0;
            for (int i = 0; i <len ; i++) {
                if (S.charAt(i) == '(') {
                    l++;
                } else {
                    if (l > 0) {
                        l--;
                    } else {
                        r++;
                    }
                }
            }
            return l+r;
    }
}
