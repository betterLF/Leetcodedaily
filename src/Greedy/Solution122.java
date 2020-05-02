package Greedy;

/**
 * @authtor liFei
 * @date 2020/5/1-7:18
 */
public class Solution122 {
    /*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit(int[] prices) {
      int cash=0;//不拥有股票的最大利润
      int hash=-prices[0];//拥有股票的最大利润
      for (int i=1;i<prices.length;i++){
          cash=Math.max(cash,hash+prices[i]);
          hash=Math.max(hash,cash-prices[i]);
      }
      return cash;
    }
    public int maxProfit2(int[] prices) {
          int left=prices[0];
          int sum=0;
        for (int i=1;i<prices.length;i++){
                     if(prices[i]>left){
                         sum+=prices[i]-left;
                     }
                     left=prices[i];
        }
        return sum;
    }
}
