package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/8/25-7:36
 */
public class Solution643 {
    /*
    给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     */
//    public double findMaxAverage(int[] nums, int k) {
//          int left=0;
//          int max=Integer.MIN_VALUE;
//          int right=0;
//          int curSum=0;
//          while (right<nums.length){
//              curSum+=nums[right];
//              if(right-left+1==k){
//               max=Math.max(curSum,max);
//               curSum-=nums[left];
//               left++;
//              }
//              right++;
//          }
//          return max/k;
//    }
    public double findMaxAverage(int[] nums, int k) {
        int kSum = 0;
        for (int i = 0; i < k; i++) {
            kSum += nums[i];
        }
        int max = kSum;
        for (int i = 1; i <= nums.length - k; i++) {
            kSum += nums[i + k - 1] - nums[i - 1];
            max = Math.max(max, kSum);
        }
        return max/(double)k;
    }
}
