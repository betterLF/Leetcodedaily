/**
 * @authtor liFei
 * @date 2020/4/10-8:25
 */
public class Solution1143 {
    /*
    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        char t1[]=text1.toCharArray();
        char t2[]=text2.toCharArray();
        int res[][]=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
              // if(text1.charAt(i-1)==text2.charAt(j-1)){//这样耗时！，先转成字符数组
                   if(t1[i-1]==t2[j-1]){
                       res[i][j]=res[i-1][j-1]+1;
                }else{
                   res[i][j]=Math.max(res[i][j-1],res[i-1][j]);
               }
            }
        }
        return res[m][n];
    }
}
