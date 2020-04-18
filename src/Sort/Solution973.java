package Sort;

import java.util.Arrays;
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
    //快排
    public int[][] kClosest2(int[][] points, int K) {
      int start=0;
      int end=points.length-1;
      while(start<end){
          int index=patition(points,start,end);//index前的元素已经有序
          if(index+1==K){//表示正好有K个元素有序
              break;
          }else if(index+1>K){//表示前面已经有超过K个元素有序了，所以只要在左边快排就行
              end=index-1;
          }else{//表示前面没有K个元素有序了，所以只要在右边快排就行
              start=index+1;
          }
      }
        return Arrays.copyOf(points,K);
    }
    private int patition(int [][]points,int start,int end){
        int i=start+1;
        int j=end+1;
        int mid=dis(points[start][0],points[start][1]);
        while (true){
           while(dis(points[i][0],points[i][1])<mid&&i<end){
                i++;
            }
            while(dis(points[--j][0],points[j][1])>mid&&j>start);
            if(i>=j){
                break;
            }
            swap(points,i,j);
        }
        swap(points,start,j);
        return j;
    }
    private void swap(int [][]points,int i,int j){
        int temp[]=points[i];
        points[i]=points[j];
        points[j]=temp;
    }
    private int dis(int i,int j){
        return i*i+j*j;
    }
}
