package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/9/21-11:43
 */
public class Solution713 {
    /*
    给定一个正整数数组 nums。
找出该数组内乘积小于 k 的连续的子数组的个数。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
              int ans=0;
              int start=0;
              int mul=1;
        for (int i = start; i <nums.length ; i++) {
                if(mul*nums[i]<k){
                    mul*=nums[i];
                }else if(nums[i]>k){
                    start=i+1;
                    mul=1;
                }else {
                    mul*=nums[i];
                    while (start<=i&&mul>=k){
                        mul/=nums[start];
                        start++;
                    }
                }
            ans+=(i-start+1);
            System.out.println(i+","+start);
        }
        return ans;
    }
}
