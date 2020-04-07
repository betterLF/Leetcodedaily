public class Solution48 {
    /*
    给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     */
    public void rotate(int[][] matrix) {
        int temp;
           for(int i=0;i<matrix.length;i++){
               for(int j=0;j<i;j++){
                   temp=matrix[i][j];
                   matrix[i][j]=matrix[j][i];
                   matrix[j][i]=temp;
               }
           }
           for(int i=0;i<matrix.length;i++){
               int j=0,k=matrix[0].length-1;
               while(j<k){
                   temp=matrix[i][j];
                   matrix[i][j]=matrix[i][k];
                   matrix[i][k]=temp;
                   j++;
                   k--;
               }
           }
           return;
    }
}
