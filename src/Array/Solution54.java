package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/5-6:51
 */
public class Solution54 {
    /*
    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int row=matrix.length;
        if(row==0){
            return ans;
        }
        int column=matrix[0].length;
       boolean [][]temp=new boolean[row][column];
        int sum=row*column;
        int startRow=0;
        int startColumn=0;
        while (sum!=0){
            temp[startRow][startColumn]=true;
            ans.add(matrix[startRow][startColumn]);
            if(startColumn+1<column&&temp[startRow][startColumn+1]==false&&!(startRow-1>=0&&temp[startRow-1][startColumn]==false)){
                startColumn++;
            }else if(startRow+1<row&&temp[startRow+1][startColumn]==false){
                startRow++;
            }else if(startColumn-1>=0&&temp[startRow][startColumn-1]==false){
                startColumn--;
            }else{
                   startRow--;
            }
            sum--;
        }
        return ans;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int row=matrix.length;
        if(row==0){
            return ans;
        }
        int column=matrix[0].length;
        int sum=row*column;
        int right=column-1;
        int left=0;
        int top=0;
        int bottom=row-1;
        while (sum!=0){
            sum-=right-left+1;
            for (int i = left; i <=right ; i++) {
                ans.add(matrix[top][i]);
            }
            if(sum==0){
                break;
            }
            top++;
            sum-=bottom-top+1;
            for (int i = top; i <=bottom ; i++) {
                ans.add(matrix[i][right]);
            }
            if(sum==0){
                break;
            }
            right--;
            sum-=right-left+1;
            for (int i = right; i>=left ; i--) {
                ans.add(matrix[bottom][i]);
            }
            if(sum==0){
                break;
            }
            bottom--;
            sum-=bottom-top+1;
            for (int i = bottom; i>=top ; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
