package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/12-7:39
 */
public class zhousai197 {
    /*
给你一个整数数组 nums 。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
返回好数对的数目。
     */
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for (Integer key:map.keySet()){
            int temp=map.get(key);
            ans+=temp*(temp-1)/2;
        }
        return ans;
    }


    /*
给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
返回所有字符都为 1 的子字符串的数目。
由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     */
    public int numSub(String s) {
      long ans=0;
      int cur=0;
        ArrayList<Integer> num=new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='1'){
                cur++;
            }else{
                if(cur!=0){
                    num.add(cur);
                    cur=0;
                }
            }
        }
        if(cur!=0){
            num.add(cur);
            cur=0;
        }
        for (int i = 0; i <num.size() ; i++) {
           long temp=num.get(i);
            ans+=(long)(1+temp)*temp/2;
            ans%=((int)Math.pow(10,9)+7);
        }
        return (int)ans;
    }


    /*
给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，
其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[] { edges[i][1], succProb[i] });
            graph[edges[i][1]].add(new double[] { edges[i][0], succProb[i] });
        }
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));//按照概率从大到小排序
        boolean[] visited = new boolean[n];//定义是否访问过(如果访问过)
        queue.add(new double[] { start, 1 });
        while (!queue.isEmpty()) {//如果队列不为空，继续取
            double[] head = queue.remove();
            if (head[0] == end) {//如果此时刚好到达结果，直接返回，因为越往后值越小
                return head[1];
            } else if (!visited[(int) head[0]]) {//如果当前点未访问过
                visited[(int) head[0]] = true;//将其标记为已经访问
                for (double[] next : graph[(int) head[0]]) {//将该点所能到达的点以及此时对应的概率加入队列中
                    queue.add(new double[] { next[0], head[1] * next[1] });
                }
            }
        }
        return 0;
    }

}
