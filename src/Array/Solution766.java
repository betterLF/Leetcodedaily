package Array;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/6-6:45
 */
public class Solution766 {
    /*
如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
          int group[]=new int[40];
        Arrays.fill(group,-1);
          for (int i=0;i<matrix.length;i++){
              for (int j=0;j<matrix[0].length;j++){
                  int a=i-j;
                   if(a<=0){
                     if(group[20-a]!=-1){
                         if(group[20-a]!=matrix[i][j]){
                             return false;
                         }
                     }else{
                         group[20-a]=matrix[i][j];
                     }
                   }else{
                       if(group[a]!=-1){
                           if(group[a]!=matrix[i][j]){
                               return false;
                           }
                       }else{
                           group[a]=matrix[i][j];
                       }
                   }
              }
          }
          return true;
    }
}
