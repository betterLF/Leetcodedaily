package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/5-16:28
 */
public class Solution33 {
    /*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
     */
    public static void main(String[] args) {
        int []a={3,1};
        search(a,1);
    }
    public static int search(int[] nums, int target) {
         int ans=-1;
         int left=0;
         int right=nums.length-1;
         while (left<=right){
             int mid=left+(right-left)/2;
             if(nums[mid]==target){
                 ans=mid;
                 break;
             }else if(nums[mid]>target){//如果中间值大于目标值
//                 if(nums[mid]>nums[left]||mid==left) {//说明该次二分左部分有序
//                   if(nums[left]>target){//如果左边都大于目标值
//                       left=mid+1;
//                   }else{
//                       right=mid-1;
//                   }
//                 }else{//说明该次二分右部分有序
//                     right=mid-1;
//                 }
                 if((nums[mid]>nums[left]||mid==left)&&nums[left]>target) {//说明该次二分左部分有序
                         left=mid+1;
                     }else{
                         right=mid-1;
                     }
             }else{//如果中间值小于目标值
//                 if(nums[mid]<nums[right]||mid==right) {//说明该次二分右部分有序
//                     if(nums[right]<target){//如果右边都小于于目标值
//                         right=mid-1;
//                     }else{
//                         left=mid+1;
//                     }
//                 }else{//说明该次二分左部分有序
//                     left=mid+1;
//                 }
//                 }
                 if((nums[mid]<nums[right]||mid==right)&&nums[right]<target) {//说明该次二分右部分有序
                         right=mid-1;
                 }else{//说明该次二分左部分有序
                     left=mid+1;
                 }
             }
             }
         return ans;
    }
}
