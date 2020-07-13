package Math;

/**
 * @authtor liFei
 * @date 2020/7/9-18:37
 */
public class Solution357 {
    /*
    给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else if (n == 2) {
            return 91;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;
        int mul = 9 * 9;
        int count = 8;
        for (int i = 3; i <= n; i++) {
            if (count != 0) {
                mul = mul * count;
                dp[i] = dp[i - 1] + mul;
                count--;
            } else {
                return dp[i - 1];
            }
        }
        return dp[n];
    }
}
