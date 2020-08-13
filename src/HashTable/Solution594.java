package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/11-7:18
 */
public class Solution594 {
    /*
    和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     */
    public int findLHS(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer key:map.keySet()){
            if(map.containsKey(key-1)){
             ans=Math.max(ans,map.get(key)+map.get(key-1));
            }
        }
        return ans;
    }
}
