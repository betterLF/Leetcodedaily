package Array;

import java.util.Arrays;
/*
给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 */
public class Solution1295 {
    public  int findNumbers(int nums[]){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(String.valueOf(nums[i]).length()%2==0){
                count++;
            }
        }
        return count;
    }
}
