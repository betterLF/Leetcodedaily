package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/5/1-7:28
 */
public class Solution1094 {
    /*
    假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了你的第 i 次行程信息：
必须接送的乘客数量；
乘客的上车地点；
以及乘客的下车地点。
这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务
（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
     */
    public static void main(String[] args) {
        int trips[][] = {{2,1,5},{3,5,7}};
        carPooling(trips,3);
    }
    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        PriorityQueue<int []> cur=new PriorityQueue<>((n1,n2)->n1[2]-n2[2]);
        int count=1;
        int temp=trips[0][0];
        cur.add(trips[0]);
        while (count!=trips.length){
            while (cur.size()==0||(count<trips.length&&cur.peek()[2]>trips[count][1])){
                temp+=trips[count][0];
                if(temp>capacity){
                    return false;
                }
                cur.add(trips[count]);
                count++;
            }
            while (cur.size()!=0&&count!=trips.length&&cur.peek()[2]<=trips[count][1]){
                temp-=cur.poll()[0];
            }

        }
        return true;
    }
    public boolean carPooling2(int[][] trips, int capacity) {
        int len =trips.length;
        int end_location = 0;//最远距离
        for(int i =0 ;i<len;i++){
            end_location = Math.max(end_location,trips[i][2]);//找出最远距离
        }
        int[] dm = new int[end_location+1];//下标处代表此处的人数变动
        int[] result = new int[end_location+1];//代表某个距离时车上的人数
        for(int i =0 ;i<len;i++){
            dm[trips[i][1]] += trips[i][0];
            dm[trips[i][2]] += -trips[i][0];
        }
        result[0] = dm[0];
        for(int j=1;j<=end_location;j++){
            result[j] =result[j-1]+ dm[j];//上一个状态+当前状态的变化
            if(result[j] > capacity){
                return false;
            }
        }
        return true;
    }
}
