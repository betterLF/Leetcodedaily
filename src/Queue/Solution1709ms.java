package Queue;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/9-8:26
 */
public class Solution1709ms {
    /*
    有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
    而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
     */
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber2(7));
    }
//超时间限制（第251个）
    public static int getKthMagicNumber(int k) {
        List<Double> res=new ArrayList<>();
        int count=1;
        int max=Integer.MAX_VALUE;
        res.add(1.0);
        for (int i = 2; i <max&&count!=k;i++) {
            if(res.contains(i/3.0)||res.contains(i/5.0)||res.contains(i/7.0)){
                count++;
                res.add(i*1.0);
            }
        }
        double ans=res.get(count-1);

        return  (int)ans;
    }
    //队列,超限制（第643个）
    public static int getKthMagicNumber2(int k) {
        Queue<Long> m=new PriorityQueue<>();
        HashSet<Long> res=new HashSet<>();
         long t=1;
         m.add(t);
        res.add(t);
        while (res.size()!=k){
            t=m.peek();
            m.add(t*3);
            m.add(t*5);
            m.add(t*7);
            if(!res.contains(t)){
                res.add(t);
            }
            m.poll();
            }
       return (int)t;
    }
    //动态规划
    public static int getKthMagicNumber3(int k) {
        int res[]=new int[k];
        res[0]=1;
        int p3=0;
        int p5=0;
        int p7=0;
        for (int i=1;i<k;i++) {
           res[i]=Math.min(Math.min(res[p3]*3,res[p5]*5),res[p7]*7);
           if(res[i]==res[p3]*3) p3++;//不能用else if,防止5*3和3*5出现，去重！
          if(res[i]==res[p5]*5) p5++;
           if(res[i]==res[p7]*7) p7++;
        }
        return  res[k-1];
    }
}
