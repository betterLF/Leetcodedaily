package Math;

/**
 * @authtor liFei
 * @date 2020/7/4-7:24
 */
public class Solution304 {
    /*
    给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
     */
    class NumMatrix {
          private long [][]sum;
        public NumMatrix(int[][] matrix) {
            if (matrix.length != 0) {
                sum=new long[matrix.length][matrix[0].length+1];
                for (int i = 0; i < sum.length; i++) {
                    for (int j = 1; j < sum[0].length; j++) {
                        sum[i][j] = matrix[i][j-1]+sum[i][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
               long ans=0;
            for (int i = row1; i <=row2 ; i++) {
                    ans += sum[i][col2+1] - sum[i][col1];
            }
            return (int)ans;
        }
    }
}
