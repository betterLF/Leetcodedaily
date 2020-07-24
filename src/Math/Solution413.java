package Math;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/22-6:31
 */
public class Solution413 {
    /*
    如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
例如，以下数列为等差数列:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
以下数列不是等差数列。
1, 1, 2, 5, 7
数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
如果满足以下条件，则称子数组(P, Q)为等差数组：
元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
函数要返回数组 A 中所有为等差数组的子数组个数。
     */
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<=2){
            return 0;
        }
        Arrays.sort(A);
        long ans=0;
        long curCount=1;
        int dif=A[1]-A[0];
        for (int i = 2; i <A.length ; i++) {
            int curDif=A[i]-A[i-1];
            if(curDif==dif){
                curCount++;
            }else{
                dif=curDif;
                ans+=curCount*(curCount-1)/2;
                curCount=1;
            }
        }
        ans+=curCount*(curCount-1)/2;
        return (int)ans;
    }
}
