package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/18-9:07
 */
public class Solution153 {
    /*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。
     */
    public int findMin(int[] nums) {
            int left=0;
            int right=nums.length-1;
            if(nums.length==1){
                return nums[0];
            }
        if (nums[right] > nums[0]) {//排除本身有序的可能
            return nums[0];
        }
            while (left<=right){
                int mid=left+(right-left)/2;
              if(mid+1<=nums.length-1&&(nums[mid]>nums[mid+1])){
                    return nums[mid+1];
                }
                if(mid-1>=0&&(nums[mid-1]>nums[mid])){
                    return nums[mid];
                }
                   if(nums[mid]>nums[0]){//说明左边有序而且其左边肯定都大于最小值
                       left=mid+1;
                   }else{//说明右边有序
                       right=mid-1;
                   }
                }
            return -1;
    }
    }

