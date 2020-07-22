package Queue;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/7/20-7:09
 */
public class Solution447 {
    /*
    给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
    其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     */
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        for (int i = 0; i <points.length ; i++) {
            PriorityQueue<Integer> cur=new PriorityQueue<>();
            for (int j = 0; j <points.length ; j++) {
                int dis=(int)Math.pow(points[i][0]-points[j][0],2)+(int)Math.pow(points[i][1]-points[j][1],2);
                cur.add(dis);
            }
           ans+=curAns(cur);
        }
        return ans;
    }
    private int curAns(PriorityQueue<Integer> cur){
             int pre=cur.poll();
             int count=1;
             int ans=0;
             while (!cur.isEmpty()){
                 int cc=cur.poll();
                 if(cc==pre){
                     count++;
                 }else{
                     if(count>=2){
                         ans+=count*(count-1);
                     }
                     pre=cc;
                     count=1;
                 }
             }
             if(count>=2){
                 ans+=count*(count-1);
             }
             return ans;
    }
    public int numberOfBoomerangs2(int[][] points) {
        int ans=0;
        for (int i = 0; i <points.length ; i++) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int j = 0; j <points.length ; j++) {
                int dis=(int)Math.pow(points[i][0]-points[j][0],2)+(int)Math.pow(points[i][1]-points[j][1],2);
              map.put(dis,map.getOrDefault(dis,0)+1);
            }
            for (Integer value:map.values()){
                if(value>=2){
                    ans+=value*(value-1);
                }
            }
        }
        return ans;
    }
}
