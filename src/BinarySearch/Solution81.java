package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/10-16:42
 */
public class Solution81 {
    /*

假设按照升序排序的数组在预先未知的某个点上进行了旋转
( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     */
    public static void main(String[] args) {
        int []a={3,1};
        search(a,1);
    }
    public static boolean search(int[] nums, int target) {
               int left=0;
               int right=nums.length-1;
               while (left<=right){
                   int mid=left+(right-left)/2;
                   if(nums[mid]==target){
                       return true;
                   }else if(nums[mid]>target) {
                       if (nums[left] < nums[mid] && nums[left] > target) {//如果左部分有序并且左边最小值>目标值
                           left = mid + 1;
                       } else {
                           if (nums[left] == nums[mid]) {
                               left++;
                           } else {
                               right = mid - 1;
                           }
                       }
                   }else{
                       if(nums[right]>nums[mid]&&nums[right]<target){//如果右部分有序并且右边最大值<目标值
                           right=mid-1;
                       }else{
                           if(nums[right]==nums[mid]){
                               right--;
                           }else {
                               left = mid + 1;
                           }
                       }
                   }
               }
               return false;
    }
    public boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid]) {//如果左值==中间值，左值后移继续判断(因为此时无法判断左右谁有序)
                left++;
                continue;
            }

            if (nums[mid] >nums[left]) {//如果左边有序
                if (nums[mid] > target && target >= nums[left]) {//如果目标值在左边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//如果右边有序
                if (nums[mid] < target && target <= nums[right]) {//如果目标值在右边
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
