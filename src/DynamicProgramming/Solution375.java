package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/7/11-7:21
 */
public class Solution375 {
    /*
我们正在玩一个猜数游戏，游戏规则如下：
我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
     */
    public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 1][n + 1];
            for (int len = 2; len <= n; len++) {//当前猜测区间的长度
                for (int start = 1; start <= n - len + 1; start++) {//当前猜测区间的初始位置
                    int minres = Integer.MAX_VALUE;
                    for (int piv = start; piv < start + len - 1; piv++) {//当前猜测区间各个值的大小
                        int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                        minres = Math.min(res, minres);
                    }
                    dp[start][start + len - 1] = minres;
                }
            }
            return dp[1][n];
        }
    }
