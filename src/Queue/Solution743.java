package Queue;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/24-12:35
 */
public class Solution743 {
    /*
有 N 个网络节点，标记为 1 到 N。
给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int []>> map=new HashMap<Integer, List<int[]>>();
        for (int i = 0; i <times.length ; i++) {
            if(map.containsKey(times[i][0])){
                map.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
            }else{
                List<int []> cur=new ArrayList<>();
                cur.add(new int[]{times[i][1],times[i][2]});
                map.put(times[i][0],cur);
            }
        }
        int []dis=new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        boolean []visited=new boolean[N+1];
        dis[K]=0;
        dis[0]=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->(dis[o1]-dis[o2]));
        queue.add(K);
        while (!queue.isEmpty()){
            int poll=queue.poll();
            if(visited[poll]){
                continue;
            }
            visited[poll]=true;
            for (int []cur:map.get(poll)){
                if(visited[cur[0]]){
                    continue;
                }else{
                    dis[cur[0]]=Math.min(dis[cur[0]],dis[poll]+cur[1]);
                    queue.add(cur[0]);
                }
            }
        }
        int max=0;
        for (int cur:dis) {
                max=Math.max(max,cur);
        }
        return max==Integer.MAX_VALUE?-1:max;

    }
}
