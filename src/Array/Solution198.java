package Array;

/**
 * @authtor liFei
 * @date 2020/5/29-7:05
 */
public class Solution198 {
    /*
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        if(nums.length==0){
               return 0;
        }else if(nums.length==1){
            return nums[0];
        }
          int len=nums.length;
          int []dp=new int[len];
          dp[0]=nums[0];
          dp[1]=nums[1];
          int []max=new int[len];
          max[0]=dp[0];
          max[1]=Math.max(dp[0],dp[1]);
        for (int i = 2; i <nums.length ; i++) {
            dp[i]=max[i-2]+nums[i];
            max[i]=Math.max(dp[i],max[i-1]);
        }
        return max[len-1];
    }
}
