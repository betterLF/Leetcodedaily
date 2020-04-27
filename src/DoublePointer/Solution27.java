package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/25-8:35
 */
public class Solution27 {
    /*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
//            if(nums[i]==val){
//                valNum++;
//            }else{
//                nums[count]=nums[i];
//                count++;
//            }
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}
