package Recursion;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/27-10:53
 */
public class Solution787 {
    /*
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<int[]>> map=new HashMap<>();
        for (int i = 0; i <flights.length ; i++) {
            if(map.containsKey(flights[i][0])){
                map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
            }else{
                List<int []> cur=new ArrayList<>();
                cur.add(new int[]{flights[i][1],flights[i][2]});
                map.put(flights[i][0],cur);
            }
        }
        PriorityQueue<int []> queue=new PriorityQueue<>((n1,n2)->n1[1]-n2[1]);
        queue.add(new int[]{src,0,0});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if(poll[0]==dst){
                return poll[1];
            }
            if(poll[2]==K+1){
                break;
            }
            if(!map.containsKey(poll[0])){
                continue;
            }
            for (int []cur:map.get(poll[0])) {
                queue.add(new int[]{cur[0],cur[1]+poll[1],poll[2]+1});
            }
        }
        return -1;
    }
}
