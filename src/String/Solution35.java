package String;

/**
 * @authtor liFei
 * @date 2020/5/25-13:22
 */
public class Solution35 {
    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
     */
    public int searchInsert(int[] nums, int target) {
            if(target<=nums[0]){
                return 0;
            }else if(target>nums[nums.length-1]){
                return nums.length;
            }
            int left=0;
            int right=nums.length;
            while (left<right){
                int mid=left+(right-left)/2;
                int cur=nums[mid];
                if(cur==target){
                    return mid;
                }else if(cur>target){
                    if(nums[mid-1]<target){
                        return mid;
                    }else{
                        right=mid;
                    }
                }else if(cur<target){
                    if(nums[mid+1]>target){
                        return mid+1;
                    }else{
                        left=mid+1;
                    }
                }
            }
            return -1;
        }
    }

