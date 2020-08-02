package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/7/30-7:57
 */
public class Solution464 {
    /*
    在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。
如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？
例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），
判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？
你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger >= desiredTotal) return true;
            if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
            /**
             *  dp表示"每个"取数(A和B共同作用的结果)状态下的输赢
             *  例如只有1,2两个数选择，那么 (1 << 2) - 1 = 4 - 1 = 3种状态表示：
             *  01,10,11分别表示：A和B已经选了1，已经选了2，已经选了1、2状态下，A的输赢情况
             *  并且可见这个表示所有状态的dp数组的每个状态元素的长度为maxChoosableInteger位的二进制数
             */
            Boolean[] dp = new Boolean[(1 << maxChoosableInteger)];
            return dfs(maxChoosableInteger, desiredTotal, 0, dp);
        }

        /**
         * @param maxChoosableInteger 选择的数的范围[1,2,...maxChoosableInteger]
         * @param desiredTotal 目标和
         * @param state 当前状态的十进制表示（记录着可能不止一个数被选择的状态）
         * @param dp 记录所有状态
         * @return
         */
        private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
            if (dp[state] != null)
                return dp[state];
            for (int i = 1; i <= maxChoosableInteger; i++){
                int tmp = (1 << (i - 1));
                if ((tmp & state) == 0){  //该位没有被使用过
                    if (desiredTotal - i <= 0 || !dfs(maxChoosableInteger, desiredTotal - i, tmp|state, dp)) {
                        dp[state] = true;
                        return true;
                    }
                }
            }
            //如果都赢不了
            dp[state] = false;
            return false;
        }
}
