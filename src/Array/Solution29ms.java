package Array;

/**
 * @authtor liFei
 * @date 2020/6/5-7:08
 */
public class Solution29ms {
    /*
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public int[] spiralOrder(int[][] matrix) {
        int row=matrix.length;
        if(row==0){
            return new int[0];
        }
        int column=matrix[0].length;
        boolean [][]temp=new boolean[row][column];
        int sum=row*column;
        int startRow=0;
        int startColumn=0;
        int []ans=new int[sum];
        int count=0;
        while (sum!=0){
            temp[startRow][startColumn]=true;
            ans[count]=matrix[startRow][startColumn];
            count++;
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
    public int[] spiralOrder2(int[][] matrix) {
        int row=matrix.length;
        if(row==0){
            return new int[0];
        }
        int column=matrix[0].length;
        int sum=row*column;
        int right=column-1;
        int left=0;
        int top=0;
        int bottom=row-1;
        int count=0;
        int []ans=new int[sum];
        while (count!=sum){
            for (int i = left; i <=right ; i++) {
                ans[count++]=matrix[top][i];
            }
            if(sum==count){
                break;
            }
            top++;
            for (int i = top; i <=bottom ; i++) {
                ans[count++]=matrix[i][right];
            }
            if(sum==count){
                break;
            }
            right--;
            for (int i = right; i>=left ; i--) {
                ans[count++]=matrix[bottom][i];
            }
            if(sum==count){
                break;
            }
            bottom--;
            for (int i = bottom; i>=top ; i--) {
                ans[count++]=matrix[i][left];
            }
            left++;
        }
        return ans;
    }

}
