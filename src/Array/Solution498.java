package Array;

/**
 * @authtor liFei
 * @date 2020/8/4-7:06
 */
public class Solution498 {
    /*
    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int m=matrix.length;
        if(m==0){
            return new int[0];
        }
        int n=matrix[0].length;
           boolean [][]visited=new boolean[m][n];
           int []ans=new int[m*n];
           int curRow=0;
           int curCol=0;
           int i=0;
           boolean flag=true;//false代表向下遍历
           ans[0]=matrix[0][0];
           while (i!=ans.length){
               ans[i]=matrix[curRow][curCol];
               if(!flag){//向下遍历
                   if(curRow+1<m&&curCol-1>=0){//没有到达向下遍历的末尾
                       curRow++;
                       curCol--;
                   }else{
                       if(curRow+1<m&&curCol>=0){
                           curRow++;
                           flag=true;
                       }else{
                           curCol++;
                           flag=true;
                       }
                   }
               }else{//向上遍历
                   if(curRow-1>=0&&curCol+1<n){//没有到达向上遍历的末尾
                       curRow--;
                       curCol++;
                   }else{
                       if(curRow>=0&&curCol+1<n){
                           curCol++;
                           flag=false;
                       }else{
                           curRow++;
                           flag=false;
                       }
                   }
               }
               i++;
           }
           return ans;
    }
}
