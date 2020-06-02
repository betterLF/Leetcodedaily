/**
 * @authtor liFei
 * @date 2020/6/3-7:16
 */
public class Solution837 {
    /*
    爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，
其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
     */
    public double new21Game(int N, int K, int W) {
            if (K == 0) {//如果K=0，肯定获胜，返回1
                return 1.0;
            }
            double[] dp = new double[K + W + 1];//dp[i]表示得分为x时该点获胜的概率
            for (int i = K; i <= N && i < K + W; i++) {//i在K到Min(K+W,N)之间为获胜，直接为1
                dp[i] = 1.0;
            }
            dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
            for (int i = K - 2; i >= 0; i--) {//相邻两项的递推公式
                dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
            }
            return dp[0];
        }
    public double new21Game2(int N, int K, int W) {
        //自底向上法就是将自顶向下法改写。
        //参考自顶向下法就很容易可以看懂了。
        double[] dp = new double[N+W+1];
        for (int i = K; i <= N; i++) dp[i] = 1.0;//如果和在K与N之间，那么返回1
        double sum = Math.min(N - K + 1, W);//如果W比N与K之间的这段长度短，那么W之后的和是取不到的。
        for (int i = K - 1; i >= 0; --i) {
            dp[i] = sum / W;
            //由于每次递归都是调用f(i) += f(i+1) + f(i+2) ... + f(i+w)
            //所以我们自底向上dp时，从f(i)到f(i-1)只要加上f(i)，减去f(i+w)就行了。因为是从f(i)开始，到f(w-1)结束。
            sum += dp[i] - dp[i+W];
        }
        return dp[0];
    }

}
