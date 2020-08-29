package Array;

/**
 * @authtor liFei
 * @date 2020/8/26-6:36
 */
public class Solution661 {
    /*
    包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
    平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     */
    public int[][] imageSmoother(int[][] M) {
        int [][]index=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
        int row=M.length;
        int col=M[0].length;
        int [][]ans=new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                ans[i][j]=getAns(M,index,i,j);
            }
        }
        return ans;
    }
    private int getAns(int [][]M,int [][]index,int row_Index,int col_Index){
        int sum=0;
        int count=0;
        for (int []arr:index) {
            int curRow=row_Index+arr[0];
            int curCol=col_Index+arr[1];
            if(0<=curRow&&curRow<M.length&&0<=curCol&&curCol<M[0].length){
                sum+=M[curRow][curCol];
                count++;
            }
        }
        return sum/count;
    }
}
