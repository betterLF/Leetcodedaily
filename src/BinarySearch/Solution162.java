package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/19-7:41
 */
public class Solution162 {
    /*
峰值元素是指其值大于左右相邻值的元素。
给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞。
     */
    public int findPeakElement(int[] nums) {
              if(nums.length==0){
                  return -1;
              }
        if(nums.length==1){
            return 0;
        }
              if(nums[0]>nums[1]){
                  return 0;
              }
             if(nums[nums.length-1]>nums[nums.length-2]){
             return nums.length-1;
            }
             int left=1;
             int right=nums.length-2;
             int ans=BinarySearch(nums,left,right);
             return ans;
    }
    private int BinarySearch(int []nums,int left,int right){
        if(left>right){
            return -1;
        }else{
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }else{
                int temp=BinarySearch(nums,left,mid-1);
                if(temp!=-1){
                    return temp;
                }
                temp=BinarySearch(nums,mid+1,right);
                if(temp!=-1){
                    return temp;
                }
            }
        }
        return -1;
    }
}
