package Array;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/26-10:43
 */
public class Solution16 {
    /*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     */
    public static void main(String[] args) {
        int a[]={14,-1,1,2};
        threeSumClosest(a,1);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=65535;
        for (int i = 0; i <nums.length ; i++) {
            int curTarget=target-nums[i];
                   int j=i+1;
                   int k=nums.length-1;
                   while (j<k){
                       int temp=nums[j]+nums[k]-curTarget;
                       if(temp>0){
                           k--;
                       }else if(temp<0){
                           j++;
                       }else{//如果刚好相等，直接返回目标值
                           return target;
                       }
                       if(Math.abs(ans)>Math.abs(temp)){
                           ans=temp;
                       }
                   }
        }
        return target+ans;
    }
}
