package Array;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/22-7:10
 */
public class Solution73 {
    /*
    给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     */

    //位运算超限制
    public  void setZeroes(int[][] matrix) {
                 long row=0;//从尾到前数，第几位是1，第几行就有0
                 long column=0;//从尾到前数，第几位是1，第几列就有0
                 int m=matrix.length;
                 int n=matrix[0].length;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==0){
                        row |= (1 << i);
                        column |= (1 << j);
                }
            }
        }
        for (int i = 0; i <m ; i++) {//行置0
            if((row&(1<<i))!=0){
            Arrays.fill(matrix[i],0);
            }
        }
        for (int i = 0; i <n; i++) {//列置0
                if ((column & (1 << i)) != 0) {
                    columnToZero(matrix, i);
                }
            }
        }
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        // 第一行是否有零
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
                break;
            }
        }
        // 第一列是否有零
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
                break;
            }
        }
        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {//说明该行该列要置为0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < row; i++) {//除去第0行和第0列，置0
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0_flag) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    private  void columnToZero(int [][]matrix,int column){
        for (int i = 0; i <matrix.length ; i++) {
            matrix[i][column]=0;
        }
    }
}
