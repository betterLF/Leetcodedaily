package Backtracking;

/**
 * @authtor liFei
 * @date 2020/8/3-8:07
 */
public class Solution494 {
    /*
    给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
    对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     */
    public int ans;
    public int findTargetSumWays(int[] nums, int S) {
                  dfs(nums,S,0,0);
                  return ans;
    }
    private void dfs(int []nums,int S,int curNum,int curIndex){
        if(curIndex==nums.length){
            if(S==curNum){
                ans++;
            }
            return;
        }
        dfs(nums,S,curNum+nums[curIndex],curIndex+1);
        dfs(nums,S,curNum-nums[curIndex],curIndex+1);
    }
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;//如果第一个数为0则有两种可能
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {//如果sum+1000这个可能存在
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

}
