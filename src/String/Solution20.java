package String;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/5/25-7:45
 */
public class Solution20 {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
     */
    public static void main(String[] args) {
        isValid("()[]{}");
    }
    public static boolean isValid(String s) {
        Stack<Character>  ans=new Stack<>();
        char[] c=s.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                ans.push(c[i]);
            } else if (c[i] == ' ') {
                continue;
            } else {
                if (ans.size() != 0) {
                    char cur = ans.pop();
                    if ((cur == '[' && c[i] == ']') || (cur == '(' && c[i] == ')') || (cur == '{' && c[i] == '}')) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(ans.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
