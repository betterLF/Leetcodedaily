package DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/6/27-7:41
 */
public class Solution220 {
    /*
    在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 
    的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
如果存在则返回 true，不存在返回 false。
     */
    //550ms
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i= 0; i <nums.length-1 ; i++) {
                  int j=Math.min(i+k,nums.length-1);
                  long a=nums[i];
                  while (j>i){
                      long b=nums[j];
                      if(Math.abs(a-b)<=t){
                          return true;
                      }
                      j--;
                  }
        }
               return false;
    }
    //桶排序
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))//如果当前桶中包含该区间的值，返回true
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)//如果当前桶前面一个桶存在并且其值和现在值相差符合要求
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);//将该点加入map集合中(因为只要一个标号m中的元素出现两次，就直接true，所以m的value域可以只存放当前最近的一次值)
            if (i >= k) d.remove(getID(nums[i - k], w));//只要map中元素个数超过满足区间的最大值，就移除其第一个元素
        }
        return false;
    }
}
