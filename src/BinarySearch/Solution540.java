package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/8/18-7:36
 */
public class Solution540 {
    /*
    给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     */
    public int singleNonDuplicate(int[] nums) {
        int i=0;
        int j=nums.length-1;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[i+1]!=nums[i]){
            return nums[i];
        }
        i++;
        if(nums[j-1]!=nums[j]){
            return nums[j];
        }
        j--;
        while (i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid-1]==nums[mid]){
                if((nums.length-mid+2)%2==0){
                    j=mid;
                }else{
                    i=mid+1;
                }
            }else if(nums[mid+1]==nums[mid]){
                if((nums.length-mid+1)%2==0){
                    j=mid;
                }else{
                    i=mid+1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[i];
    }
}
