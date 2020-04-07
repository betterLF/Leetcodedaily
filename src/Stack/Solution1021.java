package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/6-17:22
 */
public class Solution1021 {
    /*
    有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
    例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     */
    public static void main(String[] args) {
        String t="(()())(())";
        removeOuterParentheses2(t);
    }
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        Stack<Character> ss = new Stack<>();
        int len = S.length();
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') {
                countLeft++;
                ss.push('(');
            } else {
                countRight++;
                if (countLeft == countRight) {
                    StringBuilder n = new StringBuilder();
                    while (ss.size() != 1) {
                        n.append(ss.pop());
                    }
                    ss.pop();
                    res.append(n.reverse());
                } else {
                    ss.push(')');
                }
            }
        }
        return res.toString();
    }

    //不用栈


    public static  String removeOuterParentheses2(String S) {
        StringBuilder res = new StringBuilder();
        int level = 0;
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') {
                level++;
                if (level != 1) {
                    res.append(S.charAt(i));
                }
            } else {
                level--;
                if (level != 0) {
                    res.append(S.charAt(i));
                }
            }
        }
        return res.toString();
    }
}