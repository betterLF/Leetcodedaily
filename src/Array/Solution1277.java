package Array;

/**
 * @authtor liFei
 * @date 2020/5/7-19:31
 */
public class Solution1277 {
    /*
    给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
     */
    public static void main(String[] args) {
        int a[][]= {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
};
        countSquares(a);
    }
    public static int countSquares(int[][] matrix) {
           int m=matrix.length;
           int n=matrix[0].length;
           int dp[][]=new int[m][n];
           int ans=0;
           for (int i=0;i<m;i++){
               for (int j=0;j<n;j++) {
                   if (i == 0 || j == 0) {
                       dp[i][j] = matrix[i][j];
                   } else if (matrix[i][j] == 0) {
                       dp[i][j] = 0;
                   } else {
                       dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                   }
                   ans += dp[i][j];
               }
           }
           return ans;
    }
}
