package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/6/27-7:11
 */
public class Solution213 {
    /*

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
       if(nums.length==0||nums.length==2){
           return 0;
       }else if(nums.length==1){
           return nums[0];
       }
       int []dp=new int[nums.length];//偷第一个房子
       int []dp2=new int[nums.length];//不偷第一个房子
       dp[0]=nums[0];
       dp[1]=nums[0];
       dp2[0]=0;
       dp2[1]=nums[1];
        for (int i = 2; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            dp2[i]=Math.max(dp2[i-2]+nums[i],dp2[i-1]);
            }
  return Math.max(dp[nums.length-2],dp2[nums.length-1]);
            }
        }

