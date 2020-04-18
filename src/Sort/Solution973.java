package Sort;

import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/4/18-9:46
 */
public class Solution973 {
    /*
    我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
（这里，平面上两点之间的距离是欧几里德距离。）
你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     */
    public int[][] kClosest(int[][] points, int K) {
         int res[][]=new int[K][2];
        PriorityQueue<int []> cur=new PriorityQueue<>((arr1,arr2)->dis(arr1[0],arr1[1])-dis(arr2[0],arr2[1]));
              for(int[] c:points){
                  cur.add(c);
              }
//              for(int i=0;i<K;i++){
//                  res[i][0]=cur.peek()[0];
//                  res[i][1]=cur.poll()[1];
//              }
        for (int i = 0; i < K; i++) {//更简洁
            res[i] = cur.poll();
        }
              return res;
    }
    private int dis(int i,int j){
        return i*i+j*j;
    }
}
