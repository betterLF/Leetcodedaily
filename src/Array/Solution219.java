package Array;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/6/22-6:15
 */
public class Solution219 {
    /*

给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                    return true; }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
