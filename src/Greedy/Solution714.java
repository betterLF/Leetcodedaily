package Greedy;

/**
 * @authtor liFei
 * @date 2020/4/30-10:27
 */
public class Solution714 {
    /*
    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     */
    public static void main(String[] args) {
        int a[]={1, 3, 2, 8, 4, 9};
        maxProfit(a,2);
    }
    //方法一：超时间限制
    public static int maxProfit(int[] prices, int fee) {
        int len=prices.length;
     int maxPrice[]=new int[len];
     for (int i=len-2;i>=0;i--){
         maxPrice[i]=getMaxPriceByIndex(prices,maxPrice,i,fee);
     }
     return maxPrice[0];
    }
        private static int getMaxPriceByIndex(int prices[],int maxPrice[],int index,int fee){
        int max=maxPrice[index+1];
        for (int i=index+1;i<maxPrice.length;i++){
            int temp=prices[i]-prices[index]-fee;
            if(temp>0){
                if(i+1<maxPrice.length) {
                    int cur = temp + maxPrice[i + 1];
                    max=max>cur?max:cur;
                }else{
                    max=max>temp?max:temp;
                }
            }
        }
        return max;
        }
        //方法二：
    /*我们维护两个变量 \mathrm{cash}cash 和 \mathrm{hold}hold，前者表示当我们不持有股票时的最大利润，
    后者表示当我们持有股票时的最大利润。
    在第 ii 天时，我们需要根据第 i - 1i−1 天的状态来更新 \mathrm{cash}cash 和 \mathrm{hold}hold 的值。
    对于 \mathrm{cash}cash，
    我们可以保持不变，或者将手上的股票卖出，状态转移方程为
    对于 \mathrm{hold}hold，我们可以保持不变，或者买入这一天的股票*/
        public int maxProfit2(int[] prices, int fee) {
            int cash = 0, hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash = Math.max(cash, hold + prices[i] - fee);
                hold = Math.max(hold, cash - prices[i]);
            }
            return cash;
        }
}
