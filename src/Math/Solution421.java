package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * @authtor liFei
 * @date 2020/7/23-7:51
 */
public class Solution421 {
    /*
    给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
     */
    public int findMaximumXOR(int[] nums) {
            int maxNum = nums[0];
            for(int num : nums) maxNum = Math.max(maxNum, num);
            int L = (Integer.toBinaryString(maxNum)).length();//得到最大二进制长度
            int maxXor = 0, currXor;
            Set<Integer> prefixes = new HashSet<>();
            for(int i = L - 1; i > -1; --i) {
                maxXor <<= 1;//将最后一位置0，其余数左移(如果第一次满足，则最后第一次的1移到最前端)
                currXor = maxXor | 1;
                prefixes.clear();
                for(int num: nums) prefixes.add(num >> i);//得到前L-i位的值
                for(int p: prefixes) {
                    if (prefixes.contains(currXor^p)) {//如果当前结果集中存在一点使得与当前可能最大值相异或在set中，说明currXor可以存在
                        maxXor = currXor;
                        break;
                    }
                }
            }
            return maxXor;
        }

    }

