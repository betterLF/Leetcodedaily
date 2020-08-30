package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/8/27-6:58
 */
public class Solution674 {
    /*
    给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
     */
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int left=0;
        int right=1;
        int ans=1;
        while (right<nums.length){
            if(nums[right]>nums[right-1]){
                right++;
            }else{
                ans=Math.max(ans,right-left);
                left=right;
                right=right+1;
            }
        }
        ans=Math.max(ans,right-left);
        return ans;
    }
}
