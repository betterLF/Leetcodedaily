package Array;

/**
 * @authtor liFei
 * @date 2020/5/13-18:31
 */
public class Solution169 {
    /*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
     int sum=1;
     int ans=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(ans==nums[i]){
                sum++;
            }else{
                sum--;
                if(sum==0){
                    ans=nums[i];
                    sum=1;
                }
            }
        }
        return ans;
    }
}
