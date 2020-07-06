package BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/7/2-7:24
 */
public class Solution378 {
    /*
    给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     */
    //1.归并排序
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i <matrix.length ; i++) {
            queue.add(new int[]{matrix[i][0],i,0});//存放值和行列下标
        }
        for (int i = 0; i <k-1 ; i++) {
            int []cur=queue.poll();
            if(cur[2]!=matrix[0].length-1){//如果该行元素没有到达末尾
                queue.add(new int[]{matrix[cur[1]][cur[2]+1],cur[1],cur[2]+1});
            }
        }
        return queue.poll()[0];
    }
    public int kthSmallest2(int[][] matrix, int k) {
        int len=matrix.length;
      int left=matrix[0][0];
      int right=matrix[len-1][len-1];
      while (left<right){
          int mid=left+(right-left)/2;
          if(isRight(matrix,mid,k,len)){
              right=mid;
          }else{
              left=mid+1;
          }
      }
      return left;
    }
           private boolean isRight(int [][]matrix,int mid,int k,int n){
                   int i=n-1;
                   int j=0;
                   int ans=0;
                   while (i>=0&&j<n){//求出小于等于mid的元素个数
                       if(matrix[i][j]<=mid){
                           ans+=i+1;
                           j++;
                       }else{
                           i--;
                       }
                   }
                   return ans>=k;
           }
}
