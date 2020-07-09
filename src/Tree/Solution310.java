package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/7/6-6:54
 */
public class Solution310 {
    /*
    对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
    给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
格式
该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<ArrayList<Integer>> temp=new ArrayList<>();
        boolean []isVisited=new boolean[n];
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            ArrayList<Integer> t=new ArrayList<>();
            temp.add(t);
        }
        for (int i = 0; i <edges.length ; i++) {
            temp.get(edges[i][0]).add(edges[i][1]);
            temp.get(edges[i][1]).add(edges[i][0]);
        }
        isVisited[0]=true;
        int curMax=dfs(0,isVisited,0,temp,0);
        ans.add(0);
        for (int i = 1; i <n ; i++) {
            isVisited=new boolean[n];
            isVisited[i]=true;
           int cur=dfs(i,isVisited,0,temp,curMax);
           if(cur<curMax){//如果当前数高度小于之前的最小树
               ans.clear();//清空树
               ans.add(i);
               curMax=cur;
           }else if(cur==curMax){
               ans.add(i);
           }
        }
        return ans;
    }
    private int dfs(int curNum,boolean []isVisited,int depth,List<ArrayList<Integer>> temp,int curMaxValue){
        if(curMaxValue!=0&&depth>curMaxValue){//剪枝，当前深度小于最小高度树深度
            return  depth;
        }
        int curMax=depth;
           ArrayList<Integer> cur=temp.get(curNum);
        for (int i = 0; i <cur.size() ; i++) {
            if(!isVisited[cur.get(i)]){
                isVisited[cur.get(i)]=true;
             curMax=Math.max(dfs(cur.get(i),isVisited,depth+1,temp,curMaxValue),curMax);
             if(curMaxValue!=0&&curMax>curMaxValue){//如果当前最大深度超过队列最小值，直接返回
                 return curMax;
             }
            }
        }
        return curMax;

    }
        public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            /*如果只有一个节点，那么他就是最小高度树*/
            if (n == 1) {
                res.add(0);
                return res;
            }
            /*建立各个节点的出度表*/
            int[] degree = new int[n];
            /*建立图关系，在每个节点的list中存储相连节点*/
            List<List<Integer>> map = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                degree[edge[0]]++;
                degree[edge[1]]++;/*出度++*/
                map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
                map.get(edge[1]).add(edge[0]);
            }
            /*建立队列*/
            Queue<Integer> queue = new LinkedList<>();
            /*把所有出度为1的节点，也就是叶子节点入队*/
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) queue.offer(i);
            }
            /*循环条件当然是经典的不空判断*/
            while (!queue.isEmpty()) {
                res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/
                int size = queue.size();/*这是每一层的节点的数量*/
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    res.add(cur);
                    List<Integer> neighbors = map.get(cur);
                    for (int neighbor : neighbors) {
                        degree[neighbor]--;
                        if (degree[neighbor] == 1) {
                            /*如果是叶子节点我们就入队*/
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return res;/*返回最后一次保存的list*/
        }
}
