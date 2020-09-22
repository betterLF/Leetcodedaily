package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/9/19-8:24
 */
public class Solution712 {
    /*
    给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
         int [][]dp=new int[m+1][n+1];
        for (int i = m-1; i>=0 ; i--) {
            dp[i][n]=dp[i+1][n]+s1.charAt(i);
        }
        for (int i = n-1; i>=0 ; i--) {
            dp[m][i]=dp[m][i+1]+s2.charAt(i);
        }
        for (int i = m-1; i>=0 ; i--) {
            for (int j = n-1; j>=0 ; j--) {
                int one=s1.charAt(i);
                int two=s2.charAt(j);
                if(one==two){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.min(dp[i+1][j]+one,dp[i][j+1]+two);
                }
            }
        }
        return dp[0][0];
    }
}
