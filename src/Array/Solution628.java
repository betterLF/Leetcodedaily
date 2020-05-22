package Array;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/21-7:21
 */
public class Solution628 {
    /*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);//如果要快的话只要找出最小的两个和最大的三个即可
        int len=nums.length-1;
        if(nums[1]>=0){//负数只有一个或者没有负数
            return nums[len]*nums[len-1]*nums[len-2];
        }else if(nums[1]<0){//负数有两个
            return Math.max(nums[len]*nums[len-1]*nums[len-2],nums[len]*nums[0]*nums[1]);
        }
        return 0;
    }

}

