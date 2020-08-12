package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/8/10-7:27
 */
public class Solution581 {
    /*
    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。
     */
    public int findUnsortedSubarray(int[] nums) {
                 int []copy= Arrays.copyOf(nums,nums.length);
                 Arrays.sort(copy);
                 int i=0;
                 int j=nums.length-1;
                 while (i<nums.length){
                     if(nums[i]!=copy[i]){
                         break;
                     }
                     i++;
                 }
                 while (j>=0){
                    if(nums[j]!=copy[j]){
                      break;
                    }
                   j--;
                 }
                 if(i==nums.length){//全部有序
                     return 0;
                 }
                 return j-i+1;
    }
    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {//找到不是升序排列后的最小值
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {//找到不是升序排列后的最大值
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;//得到最小值和最大值的正确位置
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
