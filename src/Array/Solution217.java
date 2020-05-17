package Array;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/5/16-9:01
 */
public class Solution217 {
    /*
    给定一个整数数组，判断是否存在重复元素。
如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ans=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
           ans.add(nums[i]);
        }
        return ans.size()==nums.length?false:true;
    }
}
