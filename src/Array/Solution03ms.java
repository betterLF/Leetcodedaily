package Array;

public class Solution03ms {
    /*
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
    但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */
    public int findRepeatNumber(int[] nums) {
       int res[]=new int[100000];
       for(int num:nums){
           res[num]++;
       }
      for(int i=0;i<res.length;i++){
          if(res[i]>=2){
              return i;
          }
      }
        return -1;
    }
    public int findRepeatNumber2(int[] nums) {
//原地置换？？更快
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
