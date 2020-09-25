package Math;

/**
 * @authtor liFei
 * @date 2020/9/23-8:03
 */
public class Solution738 {
    /*
    给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     */
    public int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;//得到i呈现上升趋势的最后一个位置
        while (0 < i && i < S.length && S[i-1] > S[i]) S[--i]--;//将当前该位置前一个值减1，如果此时前一个值小于前前面一个，继续减，直到满足递增关系。
        for (int j = i+1; j < S.length; ++j) S[j] = '9';//将i+1位置后的所有元素置为9
        return Integer.parseInt(String.valueOf(S));
    }

}
