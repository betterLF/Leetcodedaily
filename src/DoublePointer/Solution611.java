package DoublePointer;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/9/10-8:13
 */
public class Solution611 {
    /*
    给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
     */
//    public int triangleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int ans=0;
//        for (int i = 0; i <nums.length ; i++) {
//            for (int j = i+1; j <nums.length ; j++) {
//                int cur=nums[i]+nums[j];
//                for (int k = j+1; k <nums.length ; k++) {
//                  if(cur<=nums[k]){
//                      break;
//                  }
//                  ans++;
//                }
//            }
//        }
//        return ans;
//    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for (int i = nums.length-1; i>=2 ; i--) {
        int left=0;
        int right=i-1;
        int max=nums[i];
        while (left<right){
            if(nums[left]+nums[right]<=max){
                left++;
            }else{
                ans+=right-left;
                right--;
            }
        }
        }
        return ans;
    }
}
