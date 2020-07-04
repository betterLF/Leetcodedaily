package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/7/1-8:17
 */
public class Solution718 {
    /*
   给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    }
     */
    public int findLength(int[] A, int[] B) {
         int m=A.length;
         int n=B.length;
         int [][]dp=new int[m+1][n+1];
         int ans=0;
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if(A[i-1]==B[j-1]) {//如果以i和j结尾的字数组元素相等，其就等于前一组+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }
}
