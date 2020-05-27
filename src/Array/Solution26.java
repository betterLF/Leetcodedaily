package Array;

/**
 * @authtor liFei
 * @date 2020/5/25-13:32
 */
public class Solution26 {
    /*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
         int count=1;
         int curVal=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=curVal){
                nums[count]=nums[i];
                count++;
                curVal=nums[i];
            }
        }
        return count;
    }
    public int removeDuplicates2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[count]){
                count++;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }
}
