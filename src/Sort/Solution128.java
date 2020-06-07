package Sort;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/6/6-7:23
 */
public class Solution128 {
    /*
    给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。
     */
    public static void main(String[] args) {
        int len[] = {2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645};
        longestConsecutive(len);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int min = 65535;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < len; i++) {
            count[nums[i] - min]++;
        }
        int ans = 0;
        int curAns = 0;
        int surplus = len;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {//如果当前元素存在
                surplus -= count[i];
                curAns++;
            } else {
                ans = Math.max(ans, curAns);//比较当前连续序列与之前最大连续序列的大小
                curAns = 0;//当前连续序列清0
                if (ans >= surplus) {//如果当前连续序列长度大于剩余元素个数总和，直接返回
                    break;
                }
            }
        }
        ans = Math.max(ans, curAns);//防止最大值在最后一项时产生
        return ans;
    }

    public static int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int cur : nums) {
            set.add(cur);
        }
        int ans = 0;
        int curAns = 1;
        for (Integer cur : set) {
            if (!set.contains(cur - 1)) {//如果hash表没有cur-1，就进行判断，这样可以只对某个连续序列的头进行判断，减少了不必要的重复判断
                while (set.contains(cur+1)) {
                    curAns++;
                    cur++;
                }
                ans=Math.max(ans,curAns);
                curAns=1;
            }
        }
        return ans;
    }
}
