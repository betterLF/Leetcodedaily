package DoublePointer;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/4/24-9:03
 */
public class Solution287 {
    /*
    给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
    可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
     */
    public int findDuplicate(int[] nums) {
         for(int i=0;i<nums.length;i++){
            int start=i+1;
             int end=nums.length-1;
             int temp=nums[i];
             while (start<=end){
                 if(nums[start]==temp||nums[end]==temp){
                     return temp;
                 }
                 start++;
                 end--;
             }
         }
         return -1;
    }
    public int findDuplicate2(int[] nums) {
        HashSet<Integer> cur=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if(cur.contains(nums[i])){
                return nums[i];
            }
            cur.add(nums[i]);
        }
        return -1;
    }

}
