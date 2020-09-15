package Math;

/**
 * @authtor liFei
 * @date 2020/9/12-8:22
 */
public class Solution908 {
    /*
    给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
返回数组 B 的最大值和最小值之间可能存在的最小差值。
     */
    public int smallestRangeI(int[] A, int K) {
        int min=A[0];
        int max=A[0];
        for (int i = 1; i <A.length ; i++) {
            if(min>A[i]){
                min=A[i];
            }else{
                max=Math.max(max,A[i]);
            }
        }
        return min+K>=max-K?0:max-min-2*K;
    }
}
