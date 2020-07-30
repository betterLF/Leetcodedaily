package Math;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/29-8:24
 */
public class Solution462 {
    /*
    给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
    其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
     */
    public int minMoves2(int[] nums) {
      quickSort(nums,0,nums.length-1);
      int target=nums[nums.length/2];
      int ans=0;
      for (int cur:nums){
          ans+=Math.abs(target-cur);
      }
      return ans;
    }
    private void quickSort(int []nums,int left,int right){
        if(left<right){
            int target=Partition(nums, left, right);
            if(target>nums.length/2){
                quickSort(nums,left,target-1);
            }else if(target<nums.length/2){
                quickSort(nums, target+1, right);
            }else{
                return;
            }
        }
    }
    private int Partition(int []nums,int left,int right){
        int i;
        int j;
        for (i=left,j=left; j <right ; j++) {
            if(nums[j]<nums[right]){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,j);
        return i;
    }
    private void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int minMoves22(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            int target=nums[nums.length/2];
        for (int i = 0; i <nums.length/2 ; i++) {
                sum+=target-nums[i];
        }
        for (int i = nums.length/2+1; i <nums.length ; i++) {
           sum+=nums[i]-target;
        }
            return sum;
        }

}
