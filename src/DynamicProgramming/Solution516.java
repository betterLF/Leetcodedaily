package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/8/13-6:51
 */
public class Solution516 {
    /*
    给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     */
    public int longestPalindromeSubseq(String s) {
       int len=s.length();
       int [][]dp=new int[len][len];
        for (int i = 0; i <len ; i++) {
            dp[i][i]=1;
        }
        for (int i = 1; i <len ; i++) {
            for (int j = 0; j+i <len ; j++) {
                    if(s.charAt(j)==s.charAt(j+i)){
                        dp[j][j+i]=dp[j+1][j+i-1]+2;
                    }else{
                        dp[j][j+i]=Math.max(dp[j+1][j+i],dp[j][j+i-1]);
                    }
            }
        }
        return dp[0][len-1];
    }
    public int longestPalindromeSubseq_2(String s) {
        int len=s.length();
        int [][]dp=new int[len][len];
        for (int i = 0; i <len ; i++) {
            dp[i][i]=1;
        }
        for (int i = len-1; i>=0; i--) {
            for (int j = i+1; j <len ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][len-1];
    }
    public int longestPalindromeSubseq3(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n];

        for (int i = n-1; i >= 0; i--) {
            dp[i] = 1;
            int pre = 0;

            for (int j = i+1; j < n; j++) {
                int temp = dp[j];

                if (chars[i] == chars[j]) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }

                pre = temp;
            }
        }
        return dp[n-1];
    }
}
