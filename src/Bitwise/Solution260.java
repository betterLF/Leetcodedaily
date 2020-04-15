package Bitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/4/15-9:55
 */
public class Solution260 {
    /*
    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     */
        public int[] singleNumber(int[] nums) {
            HashMap<Integer,Integer> res=new HashMap<>();
            int ans[]=new int[2];
            for(int cur:nums){
                res.put(cur,res.getOrDefault(cur,0)+1);
            }
            int count=0;
            for(Integer key:res.keySet()){
                if(res.get(key)==1){
                    ans[count++]=key;
                }
            }
//            for (Map.Entry<Integer, Integer> item : res.entrySet())
//                if (item.getValue() == 1) ans[count++] = item.getKey();
//                用这个更快？
            return ans;
        }
    public static int[] singleNumber2(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;
        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);
        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, bitmask^x};
    }

}
