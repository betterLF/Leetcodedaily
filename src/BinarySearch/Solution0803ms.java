package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/5/2-7:52
 */
public class Solution0803ms {
    /*
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     */
    public int ans=-1;
    public int findMagicIndex(int[] nums) {
        binarySearch(nums,0,nums.length);
        return ans;
    }
    private void binarySearch(int nums[],int start,int end){
        if(start>end){
            return;
        }
        int mid=start+(end-start)/2;
        if(nums[mid]==mid){
               ans=mid;
               binarySearch(nums,start,mid-1);
               return;
        }else {
            binarySearch(nums,start,mid-1);
            if(ans==-1)
                binarySearch(nums,mid+1,end);
        }
    }
}
