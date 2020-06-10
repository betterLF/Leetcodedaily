package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/6/10-7:12
 */
public class Solution74 {
    /*
    编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
             int m=matrix.length;
             int n=matrix[0].length;
             int left=0;
             int right=m*n-1;
             while (left<=right){
                 int mid=left+(right-left)/2;
                 int curRow=mid/n;
                 int curColumn=mid-n*curRow;
                 if(matrix[curRow][curColumn]==target){
                     return true;
                 }else if(matrix[curRow][curColumn]>target){
                     right=mid-1;
                 }else{
                     left=mid+1;
                 }
             }
             return false;
    }
}
