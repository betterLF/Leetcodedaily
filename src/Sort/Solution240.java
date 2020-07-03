package Sort;

/**
 * @authtor liFei
 * @date 2020/6/29-9:22
 */
public class Solution240 {
    /*
    编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
         int row=matrix.length-1;
         int column=0;
         while (row>=0&&column<=matrix[0].length-1){
             if(matrix[row][column]>target){
                 row--;
             }else if(matrix[row][column]<target){
                column++;
             }else{
                 return true;
             }
         }
         return false;
    }
}
