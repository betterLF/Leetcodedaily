package Array;

/**
 * @authtor liFei
 * @date 2020/5/6-7:36
 */
public class Solution1704ms {
    /*
数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
注意：本题相对书上原题稍作改动
     */
    public int missingNumber(int[] nums) {
        int len=nums.length;
         int sum=len*(len+1)/2;
         for (int i=0;i<nums.length;i++){
             sum-=nums[i];
         }
         return sum;
    }
}
