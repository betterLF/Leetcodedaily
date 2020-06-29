package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/6/26-7:08
 */
public class Solution207 {
    /*
    你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
              int []nums=new int[numCourses];//数组下标表示要修该课程的先决条件数
              List<ArrayList<Integer>> ans=new ArrayList<>();//表示该课程影响哪些课程
             for (int i = 0; i <numCourses ; i++) {
                ans.add(new ArrayList<>());
            }
        for (int i = 0; i <prerequisites.length ; i++) {
              nums[prerequisites[i][0]]++;
               ans.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i <nums.length ; i++) {//将所有没有先决条件的边加入队列中
            if(nums[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int cur=queue.poll();
            ArrayList<Integer> temp=ans.get(cur);
            for (int i = 0; i <temp.size() ; i++) {
                nums[temp.get(i)]--;//减去该条件影响的课程的一个先决条件
                if(nums[temp.get(i)]==0){//如果先决条件全部满足
                    queue.add(temp.get(i));
                }
            }
        }
        for (int i = 0; i <nums.length ; i++) {//如果课程全部加入队列
            if(nums[i]!=0){
                return false;
            }
        }
        return true;
    }
}
