package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/15-6:51
 */
public class Solution523 {
    /*
    给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
    其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k==0){
            for (int i = 0; i <nums.length-1 ; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
            k=Math.abs(k);
            int curSum=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,-1);
        for (int i = 0; i <nums.length ; i++) {
            curSum=(curSum+nums[i])%k;
             if(map.containsKey(curSum)&&map.get(curSum)<i-1){
                 return true;
             }else if(map.containsKey(curSum)){
                 continue;
             }
            map.put(curSum,i);
        }
        return false;
    }
}
