package DynamicProgramming;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/9/16-7:39
 */
public class Solution673 {
    /*
    给定一个未排序的整数数组，找到最长递增子序列的个数。
     */
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] length = new int[N];
        int[] count = new int[N];
        Arrays.fill(count, 1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] < nums[j]) {
                    if (length[i] >= length[j]) {
                        length[j] = length[i] + 1;
                        count[j] = count[i];
                    } else if (length[j] == length[i] + 1) {
                        count[j] += count[i];
                    }
                }
            }
        }
        int len = 0;
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            if (length[i] > len) {
                len = length[i];
                maxCount = count[i];
            } else if (length[i] == len) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
