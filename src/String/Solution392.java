package String;

/**
 * @authtor liFei
 * @date 2020/7/4-7:08
 */
public class Solution392 {
    /*
 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        int len=s.length();
        int len2=t.length();
        while (i<len&&j<len2){
            char cur=s.charAt(i);
            while (j<len2&&t.charAt(j)!=cur){
                j++;
            }
            if(j!=len2){
                i++;
                j++;
            }
        }
        return i==len;

    }
    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);//从1开始查找
            if (index == -1) return false;//如果没找到返回-1，否则下次从找到位置下一个开始查找
        }
        return true;
    }
}
