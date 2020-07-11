package DynamicProgramming;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/9-7:12
 */
public class Solution343 {
    /*
    给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     */
    public static int []dp=new int[59];
    static{
        dp[1]=1;
        for (int i = 2; i <59 ; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
            dp[i]=Math.max(dp[i],i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dp));
    }
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
            return dp[n];
    }
    public int integerBreak2(int n) {//数学法
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

}
