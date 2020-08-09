package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @authtor liFei
 * @date 2020/8/6-7:21
 */
public class Solution532 {
    /*
    给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
    这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     */
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        if (k < 0) {
            return ans;
        } else if (k == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (map.get(nums[i]) == 1) {
                        map.put(nums[i], 2);
                        ans++;
                    }
                } else {
                    map.put(nums[i], 1);
                }
            }
            return ans;
        } else {
            HashSet<Integer> num = new HashSet<>();
            HashSet<Integer> res = new HashSet<>();//如果找到一对，则将其较小的元素存入
            for (int i = 0; i < nums.length; i++) {
                num.add(nums[i]);
            }
            Iterator<Integer> iterator = num.iterator();
            while (iterator.hasNext()) {
                int cur = iterator.next();
                if (num.contains(cur - k) && !res.contains(cur - k)) {
                    ans++;
                    res.add(cur - k);
                } else if (num.contains(cur + k) && !res.contains(cur)) {
                    ans++;
                    res.add(cur);
                }
            }
            return ans;
        }
    }
}
