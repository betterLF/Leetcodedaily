public class Solution867 {
    /*
    给定一个矩阵 A， 返回 A 的转置矩阵。
矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     */
    public int[][] transpose(int[][] A) {
         int len1=A.length;
         int len2=A[0].length;
         int res[][]=new int[len2][len1];
         for(int i=0;i<len2;i++){
             for(int k=0;k<len1;k++){
                 res[i][k]=A[k][i];
             }
         }
         return res;
    }
}
