package Array;

/**
 * @authtor liFei
 * @date 2020/8/26-6:47
 */
public class Solution665 {
    /*
    给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     */
    public boolean checkPossibility(int[] nums) {
          int count=0;
          int i=0;
          int len=nums.length-1;
          while (count<2&&i<len){
              if(nums[i]>nums[i+1]){
                  if(i==0) {
                      count++;
                  }else if(nums[i+1]>=nums[i-1]){
                      count++;
                  }else{
                      nums[i+1]=nums[i];
                      count++;
                  }
              }
              i++;
          }
          return count<2;
    }
}
