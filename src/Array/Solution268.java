package Array;

/**
 * @authtor liFei
 * @date 2020/5/23-8:17
 */
public class Solution268 {
    /*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     */
    public int missingNumber(int[] nums) {
            int sum=nums.length*(nums.length+1)/2;
            for (int cur:nums){
                sum-=cur;
            }
            return sum;
    }
}
