package DoublePointer;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/26-7:27
 */
public class Solution844 {
    /*
    给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。
     */
    //解法1
    public boolean backspaceCompare(String S, String T) {
       Stack<Character> ss=build(S);
       Stack<Character> tt=build(T);
       if(ss.size()!=tt.size()){
           return false;
       }else if(ss.size()==0){
           return true;
       }else{
           while (ss.size()!=0){
               if(ss.pop()!=tt.pop()){
                   return false;
               }
           }
       }
       return true;
    }
    private Stack<Character> build(String s){
        Stack<Character> stack=new Stack<>();
        for (char cur:s.toCharArray()){
//            if(cur=='#'&&stack.size()!=0){
//                stack.pop();
//            }
//            if(cur!='#'){
//                stack.push(cur);
//            }
            if (cur != '#')
                stack.push(cur);
            else if (!stack.empty())
                stack.pop();
        }
        return stack;
    }
    //解法二
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }
  private static String build2(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
    //解法三：官方，O(1)空间复杂度
    /*
    思路
    一个字符是否属于最终字符串的一部分，取决于它后面有多少个退格符。
    如果反向遍历字符串，就可以先知道有多少个退格符，然后知道退格符左边有多少个字符会被删除，对应的也就知道哪些字符会保留在最终的字符串中。
    算法
    反向遍历字符串，如果遍历到一个退格符，那么再往左第一个非退格字符将会被删除，剩余未被删除的字符就是最终的字符串。
    */
    public boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

}
