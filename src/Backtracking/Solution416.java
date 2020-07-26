package Backtracking;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/22-18:57
 */
public class Solution416 {
    /*
    给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
     */
    public boolean flag;
    public boolean canPartition(int[] nums) {
        if(nums.length<2){
            return false;
        }
         int  sum=0;
         for (int num:nums){
             sum+=num;
         }
         flag=false;
         if(sum%2==1){
             return false;
         }
        Arrays.sort(nums);
         dfs(nums,nums.length-1,sum/2);
         return flag;
    }
    private void dfs(int []nums, int curIndex,int target){
        if(flag||curIndex<0||target<0){
            return;
        }
        if(target==0){
            flag=true;
            return;
        }
        for (int i = curIndex; i>=0 ; i--) {
            if(flag){
                return;
            }
            if(target-nums[i]*(i+1)>0){
                break;
            }
            dfs(nums,i-1,target-nums[i]);

        }
    }
}
