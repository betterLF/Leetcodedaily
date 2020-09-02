package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/8/31-7:49
 */
public class Solution704 {
    /*
    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
    写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public int search(int[] nums, int target) {
            int l=0;
            int r=nums.length-1;
            while (l<=r){
                int mid=l+(r-l)/2;
                if(nums[mid]<target){
                    l=mid+1;
                }else if(nums[mid]>target){
                    r=mid-1;
                }else{
                    return mid;
                }
            }
            return -1;
    }
}
