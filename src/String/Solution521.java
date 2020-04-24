package String;

/**
 * @authtor liFei
 * @date 2020/4/22-18:20
 */
public class Solution521 {
    /*
    给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
     */
    public int findLUSlength(String a, String b) {
        int len1=a.length();
        int len2=b.length();
           if(len1!=len2){//如果两字符串不等
               return Math.max(len1,len2);
           }
           for(int i=0;i<len1;i++){
               if(a.charAt(i)!=b.charAt(i)){
                   return len1;
               }
        }
           return -1;
    }
}
