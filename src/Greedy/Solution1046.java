package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/4/11-9:15
 */
public class Solution1046 {
    /*
    有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     */
    public int lastStoneWeight(int[] stones) {//java是小顶堆
        PriorityQueue<Integer> ans=new PriorityQueue<Integer>((a,b)->b-a);
        for(int cur:stones){
            ans.add(cur);
        }
        while(ans.size()!=1&&ans.size()!=0){
            int m=ans.poll()-ans.poll();
            if(m!=0){
                ans.add(m);
            }
        }
        if(ans.size()==0){
            return 0;
        }
        return ans.poll();
    }
    //排序更快？
    public int lastStoneWeight2(int[] stones) {
    int index = stones.length - 1;
        for(int i = 0; i < stones.length - 1; i++){     //通过stones.length来判断需要操作的次数。（不用将stones.length == 1的情况单独考虑）
        Arrays.sort(stones);                        //将sort放在循环体的开始。（避免在循环体外再写一次重复的sort（））
        stones[index] -= stones[index-1];           //两种不同情况使用同一表达式处理。（）
        stones[index-1] = 0;
    }
        return stones[stones.length-1];
}
}
