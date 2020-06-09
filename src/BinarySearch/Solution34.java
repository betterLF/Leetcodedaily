package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/6-7:58
 */
public class Solution34 {
    /*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
              int left=0;
              int right=nums.length-1;
              int []ans={-1,-1};
              while (left<=right){//找左边界
                  int mid=left+(right-left)/2;
                  if(nums[mid]==target){
                      if(mid==0||nums[mid-1]!=target){
                          ans[0]=mid;
                          break;
                      }else{
                          right=mid-1;
                      }
                  }else if(nums[mid]>target){
                      right=mid-1;
                  }else{
                      left=mid+1;
                  }
              }
              left=0;
              right=nums.length-1;
        while (left<=right){//找右边界
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]!=target){
                    ans[1]=mid;
                    break;
                }else{
                    left=mid+1;
                }
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}
