package Array;

/**
 * @authtor liFei
 * @date 2020/5/13-18:34
 */
public class Solution485 {
    /*
给定一个二进制数组， 计算其中最大连续1的个数。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
       int max=0;
       int count=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==1){
                count++;
            }else{
                max=Math.max(max,count);
                count=0;
            }
        }
        max=Math.max(max,count);
        return max;
    }
    //滑动窗口
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max=0;
        int left=0;
        int right=0;
       while (right<nums.length) {
            if(nums[right++]==0) {
                max=Math.max(max,right-left-1);
                left=right;
            }

        }
        max=Math.max(max,right-left);
        return max;
    }
}
