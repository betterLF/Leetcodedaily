package Design;

/**
 * @authtor liFei
 * @date 2020/7/1-7:15
 */
public class Solution303 {
    /*
    给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     */
    class NumArray {
         int []num;
         int []dp;
         int sumAll;
        public NumArray(int[] nums) {
            num=nums;
            dp=new int[nums.length];
            sumAll=0;
            for (int i = 0; i <nums.length ; i++) {
                sumAll+=nums[i];
                dp[i]=sumAll;
            }
        }

        public int sumRange(int i, int j) {
             if(i==0){
                 return dp[j];
             }else{
                 return dp[j]-dp[i-1];
             }
        }
    }
}
