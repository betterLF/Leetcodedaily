package DynamicProgramming;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/7-7:26
 */
public class Solution322 {
    /*
    给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public int ans;
    public  int coinChange(int[] coins, int amount) {
       Arrays.sort(coins);
       ans=Integer.MAX_VALUE;
      dfs(amount,coins,coins.length-1,0);
      return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void dfs(int amount,int []coins, int start,int total){
           if(start<0){//如果下标小于0直接返回
               return ;
           }
           int count=amount/coins[start];
           int last=amount%coins[start];//如果余数刚好为0，说明正好除尽
           if(last==0){
               ans=Integer.min(ans,total+count);
               return;
           }
           if(start==0){//如果此时到达末尾可是却得不到结果就返回
               return;
           }
        while(count>=0){
            int cur = amount - count*coins[start];//计算剩余量(选择的当前值个数依次下降)
            //减支
            if(count+total+1 >= ans){ //当前情况不成立，所以后续最小是count+tol+1，如果它比min大于或者等于，则不用往后了，这个值单调递增
                break;
            }
            dfs(cur,coins,start-1,count+total);
            count--;
        }

    }
    public  int coinChange2(int[] coins, int amount) {
    int []dp=new int[amount+1];//下标代表组成i时所需要的最小硬币数
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j <coins.length ; j++) {
               if(coins[j]<=i){
                   dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
               }
            }

        }
        return dp[amount]>amount?-1:dp[amount];
    }
    }

