import java.util.*;

/**
 * @authtor liFei
 * @date 2020/5/17-7:56
 */
public class Solution210 {
    /*
    现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           boolean isVisited[]=new boolean[numCourses];//判断是否访问过
           Queue<Integer> ans=new ArrayDeque<>();//存放结果
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();//key存放要学习的课程，value存放先决条件
            int []temp=new int[numCourses];//temp[i]=0时说明i课程没有任何限制和影响，所以将isVisited[i]设为true
        for (int i = 0; i <prerequisites.length ; i++) {
            temp[prerequisites[i][0]]++;
            temp[prerequisites[i][1]]++;
        }
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==0){
                isVisited[i]=true;
                ans.add(i);
            }else{
                map.put(i,new ArrayList<>());
            }
        }
           for (int i=0;i<prerequisites.length;i++){//找到每个课程的先决条件
               map.get(prerequisites[i][0]).add(prerequisites[i][1]);
           }
           ArrayList<Integer> t=new ArrayList<>();
       for (Integer key:map.keySet()){
           if(map.get(key).size()==0){//找到不被其他课程影响却能影响其他课程的课程
           //DFS(isVisited,map,key,ans);
               t.add(key);
               isVisited[key]=true;
               ans.add(key);
           }
        }
        for (int i = 0; i <t.size() ; i++) {
            DFS(isVisited,map,t.get(i),ans);
        }
       if(ans.size()==numCourses){
           int []res=new int[numCourses];
           for (int i = 0; i <numCourses ; i++) {
               res[i]=ans.poll();
           }
           return res;
       }else{
           return new int[0];
       }

    }
    private void DFS(boolean []isVisited,HashMap<Integer,ArrayList<Integer>> map,int start,Queue ans){
        if(allVisited(isVisited)){
            return;
        }
        for (Integer key:map.keySet()){
            ArrayList<Integer> temp=map.get(key);
            if(isVisited[key]==false&&temp.contains(start)){//如果该结点未被访问过并且它需要经过先决结点
                boolean flag=false;//判断是否它的先决条件都满足
                for (int i=0;i<temp.size();i++){
                    if(isVisited[temp.get(i)]!=true){
                        flag=true;//说明至少有一个不满足
                        break;
                    }
                }
                if(flag){//找下一个满足条件的点
                    continue;
                }else{
                    isVisited[key]=true;
                    ans.add(key);
                    DFS(isVisited, map, key, ans);//从这个点继续遍历
                }
            }
        }
    }
    private boolean allVisited(boolean[] isVisited){//判断是否都访问过
        for (int i = 0; i <isVisited.length ; i++) {
            if(isVisited[i]==false){
                return false;
            }
        }
        return true;
    }
    //bfs 别人的 25ms
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) {//索引代表课程，值代表先决条件的个数
            inDegrees[p[0]]++;
        }
        // 入度为0的节点入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        while (!queue.isEmpty()){//如果队列不空
            int curr = queue.poll();
            res[count++] = curr;//将出队列的元素加入结果集中
            for (int[] p : prerequisites) {
                if (p[1] == curr){//如果该元素的先决条件为curr
                    inDegrees[p[0]]--;//该元素的先决条件减一
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);//说明先决条件全部修完
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }
    //DFS 6ms
    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        // HashSet 作为邻接矩阵
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {//将每个结点可能可以通过的课程加入
            graph[p[1]].add(p[0]);
        }
        int[] mark = new int[numCourses]; // 标记数组
        Stack<Integer> stack = new Stack<>(); // 结果栈
        for (int i = 0; i < numCourses; i++) {
            if(!isCycle(graph, mark, i, stack))
                return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean isCycle(HashSet<Integer>[] graph, int[] mark, int i, Stack<Integer> stack) {
        if (mark[i] == -1) return true;//如果它在栈中，就返回true
        if (mark[i] == 1) return false;//如果它还在搜索中，说明它前面的结点不能加入结果集，返回false

        mark[i] = 1;//设置它在搜索中
        for (int neighbor : graph[i]) {
            if (!isCycle(graph, mark, neighbor, stack)) return false;//如果它能到达的结点中也有在搜索中的，则这个结点不能加入结果集
        }
        mark[i] = -1;//该结点所有能到达的结点都已经搜素完成，加入结果集
        stack.push(i);
        return true;
    }
}
