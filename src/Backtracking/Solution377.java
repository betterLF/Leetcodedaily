package Backtracking;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/11-8:50
 */
public class Solution377 {
    /*
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     */
    //递归超时
    public int ans;
    public int combinationSum4(int[] nums, int target) {
           ans=0;
           Arrays.sort(nums);
           dfs(nums, target);
           return ans;
    }
    public void dfs(int []nums,int target){
        if(target==0){
            ans++;
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(target-nums[i]<0){//剪枝
                break;
            }
            dfs(nums,target-nums[i]);
        }
    }
    //dp
    public int combinationSum42(int[] nums, int target) {
        int []dp=new int[target+1];
        dp[0]=1;// dp[i]+=dp[i-num];如果i-num=0时，说明dp[i]刚好可以由一个元素得到，所以+1
        for (int i = 1; i <=target ; i++) {
            for(int num:nums){
                if(num<=i){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
