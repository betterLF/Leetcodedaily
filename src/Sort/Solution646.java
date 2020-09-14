package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/9/11-9:04
 */
public class Solution646 {
    /*
给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     */
//    public int findLongestChain(int[][] pairs) {
//        int n = pairs.length;
//        if (n == 0) return 0;
//        int[] dp = new int[n + 1];//下标位置代表最长子序列为n时的元素最小值
//        int len = 1;//代表当前的最长子序列元素个数
//        dp[1] = pairs[0][1];
//        for (int i = 1; i < n; i++){
//            int l = 1;
//            int r = len;
//            if (pairs[i][0] > dp[len]) {//如果当前元素大于最长子序列的最后一个元素
//                dp[++len] = pairs[i][1];//最长子序列加一，而且其值为nums[i]
//            }else{
//                while (l <= r){//找到一个dp值，其值大于nums[i]
//                    int mid = (l + r) / 2;
//                    if (dp[mid] < pairs[i][0]){
//                        l = mid + 1;
//                    }else{
//                        r = mid - 1;
//                    }
//                }
//                dp[l] = pairs[i][1];
//            }
//        }
//        return len;
//    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }
}
