package Sort;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/16-9:49
 */
public class Solution1387 {
    /*
    我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
如果 x 是偶数，那么 x = x / 2
如果 x 是奇数，那么 x = 3 * x + 1
比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，
如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。

     */
    public int getKth(int lo, int hi, int k) {
        List<Integer> res=new ArrayList<Integer>();
        for (int i = lo; i <=hi ; i++) {
            res.add(i);
        }
        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int m=solveWeight(o1)-solveWeight(o2);
                if(m==0){
                    return o1-o2;
                }
                return m;
            }
        };
        Collections.sort(res,c);
        return res.get(k-1);
    }
    public int getKth2(int lo, int hi, int k) {
           int arr[][]=new int[hi-lo+1][2];
        for (int i = 0; i <hi-lo+1 ; i++) {
                 arr[i][0]=lo+i;
                 arr[i][1]=solveWeight(lo+i);
        }
          Comparator<int []> c=new Comparator<int[]>() {
              @Override
              public int compare(int[] o1, int[] o2) {
                  return o1[1]-o2[1]==0?o1[0]-o2[0]:o1[1]-o2[1];
              }
          };
        Arrays.sort(arr,c);
        return arr[k-1][0];
    }
    private int solveWeight(int i){
        int count=0;
        while (i!=1){
            i=i%2==0?i/2:i*3+1;
            count++;
        }
        return count;
    }
}
