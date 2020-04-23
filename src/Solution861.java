/**
 * @authtor liFei
 * @date 2020/4/22-6:50
 */
public class Solution861 {
    /*
    有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。
     */
    public static void main(String[] args) {
        int a[][]={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        matrixScore2(a);
    }
    public static int matrixScore(int[][] A) {
        for(int i=0;i<A.length;i++){
            if(A[i][0]!=1){
                changeRow(A,i);
            }
        }
        for (int i = 0; i <A[0].length ; i++) {
            if(judgeColumn(A,i)){
                changeColumn(A,i);
            }
        }
        int max=getValue(A);
        return max;
    }
    private static void changeRow(int [][]A,int row){
        for (int i = 0; i <A[row].length; i++) {
            A[row][i]^=1;
        }
    }
    private static void changeColumn(int [][]A,int column){
            for(int i=0;i<A.length;i++){
                A[i][column]^=1;
            }
    }
    private static boolean judgeColumn(int [][]A,int column){
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i][column]==0){
                count++;
            };
        }
        if(count>A.length/2){//如果0的个数比1多，就要转变列
            return true;
        }
        return false;
    }
    private static int getValue(int [][]A){
        int ans=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            for (int j=0;j<A[0].length;j++){
                sum=sum*2+A[i][j];
            }
            ans+=sum;
        }
        return ans;
    }
    //法二：与自己的时间空间一样，但很简洁
    public static int matrixScore2(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r)
                col += A[r][c] ^ A[r][0];//对于第一列为A[r][c] ^ A[r][0]，所以Math.max(col, R - col)令它全为1， (1 << (C-1-c));这是第一列元素对应的二进制数
            ans += Math.max(col, R - col) * (1 << (C-1-c));  //都加起来就得到第一列所有元素之和，从第二列开始计算的就是每一列0的个数
        }//从第二列开始，当 A[r][c] ^ A[r][0]=1时，要么1^0，此时因为第一位为0，所以肯定这一行要翻转，它对应的1其实就是0，要么0^1这时不用翻转，对应的0就是0，所以col算的是0的个数
        return ans;
    }
}
