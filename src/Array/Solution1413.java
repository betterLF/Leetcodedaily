package Array;

/**
 * @authtor liFei
 * @date 2020/5/5-7:18
 */
public class Solution1413 {
    /*
    给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
     */
    public int minStartValue(int[] nums) {
           int min=nums[0];
           int sum=nums[0];
           for (int i=1;i<nums.length;i++){
               sum+=nums[i];
               if(sum<min){
                   min=sum;
               }
           }
           if(min>=0){
               return 1;
           }else{
               return -min+1;
           }
    }
}
