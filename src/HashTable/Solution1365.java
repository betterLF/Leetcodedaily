package HashTable;

import java.util.Arrays;

/*
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 以数组形式返回答案。
 */
public class Solution1365 {
    //暴力
    public int[] smallerNumbersThanCurrent(int nums[]){
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                 if(nums[i]>nums[j]){
                     count++;
                 }
            }
            res[i]=count;
            count=0;
        }
        return res;
    }
    //基数排序
    public int[] smallerNumbersThanCurrent2(int nums[]) {
           int res[]=Arrays.copyOf(nums,nums.length);
           int count[]=new int[101];
           for(int num:nums){
               count[nums[num]]++;//count的索引就是它对应的值，索引的值就是nums中该值出现的次数
           }
           int count2[]=Arrays.copyOf(count,count.length);
           for(int i=1;i<count.length;i++){
               count[i]=count[i]+count[i-1];
           }//此时count索引处的值就是该索引对应的nums值大于的数的个数
        for(int i=0;i<res.length;i++){
            res[i]=count[res[i]]-count2[res[i]];
        }
           return res;
    }
    }

