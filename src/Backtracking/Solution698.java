package Backtracking;

/**
 * @authtor liFei
 * @date 2020/9/18-7:08
 */
public class Solution698 {
    /*
    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
          int sum=0;
          int max=0;
        for (int cur:nums) {
            sum+=cur;
            max=Math.max(cur,max);
        }
        int target=sum/k;
        if(sum%k!=0||max>target){
            return false;
        }else{
            boolean []flag=new boolean[nums.length];
         return Backtracking(k,0,flag,nums,0,target);
        }
    }
    private boolean Backtracking(int count,int start,boolean []flag,int []nums,int cur,int target){
        if(count==0){
            return true;
        }
          if(cur==target){
              return Backtracking(count-1,0,flag,nums,0,target);
          }
        for (int i = start; i <nums.length ; i++) {
             if(!flag[i]&&cur+nums[i]<=target){
                 flag[i]=true;
                 if(Backtracking(count,i+1, flag, nums, cur+nums[i], target)){
                     return true;
                 };
                 flag[i]=false;
             }
        }
        return false;
    }
}
