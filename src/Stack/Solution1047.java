package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/8-11:08
 */
public class Solution1047 {
    /*
    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */
    //用栈
    public String removeDuplicates(String S) {
        Stack<Character> s = new Stack<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            Character c = S.charAt(i);
            if (s.isEmpty()) {
                s.push(c);
            } else {
                if (s.peek() == c) {
                    s.pop();
                } else {
                    s.push(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.reverse().toString();
    }

    //改进
    public String removeDuplicates2(String S) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (char cur : S.toCharArray()) {//转成子符数组
            if (count != 0 && cur == res.charAt(count - 1)) {
                res.deleteCharAt(count - 1);
                count--;
            } else {
                res.append(cur);
                count++;
            }
        }
        return res.toString();
    }
}
