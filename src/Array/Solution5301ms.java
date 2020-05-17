package Array;

/**
 * @authtor liFei
 * @date 2020/5/16-8:55
 */
public class Solution5301ms {
    /*
    统计一个数字在排序数组中出现的次数
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            if(target==nums[i]){
                int j=i;
                while (nums[j]==target){
                    j++;
                }
                return j-i+1;
            }
            if(target>nums[i]){
                break;
            }
        }
        return 0;
    }
}
