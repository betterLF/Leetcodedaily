package Array;

/**
 * @authtor liFei
 * @date 2020/5/6-7:12
 */
public class Solution566 {
    /*
    在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
      int m=nums.length;
      int n=nums[0].length;
      if(m*n!=r*c){
          return nums;
      }
      int ans[][]=new int[r][c];
      int r1=0;
      int c1=0;
      for (int i=0;i<r;i++){
          for (int j=0;j<c;j++){
              if(c1!=n-1){
                  ans[i][j]=nums[r1][c1];
                  c1++;
              }else{
                  ans[i][j]=nums[r1][c1];
                  c1=0;
                  r1++;
              }
          }
      }
      return ans;
    }
}
