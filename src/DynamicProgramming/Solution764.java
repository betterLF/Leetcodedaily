package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/9/25-8:34
 */
public class Solution764 {
    /*
在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。
网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，
以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。
注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if(mines.length==N*N){
            return 0;
        }
        int [][]matrix=new int[N][N];
        for (int i = 0; i <mines.length ; i++) {
            matrix[mines[i][0]][mines[i][1]]=1;
        }
         int [][][]dp=new int[N][N][4];
        for (int i = 0; i <N ; i++) {//dp[i][j][0]代表当前位置往上有几个连续的1,dp[i][j][1]代表当前位置往左有几个连续的1，后面同理
            for (int j = 0; j <N ; j++) {
                if(matrix[i][j]==1){//代表当前位置为0
                    dp[i][j][0]=0;
                    dp[i][j][1]=0;
                }else{
                    dp[i][j][0]=i-1>=0?dp[i-1][j][0]+1:1;
                    dp[i][j][1]=j-1>=0?dp[i][j-1][1]+1:1;
                }
            }
        }
        for (int i = N-1; i>=0 ; i--) {
            for (int j =N-1; j>=0 ; j--) {
                if(matrix[i][j]==1){//代表当前位置为0
                    dp[i][j][2]=0;
                    dp[i][j][3]=0;
                }else{
                    dp[i][j][2]=i+1<N?dp[i+1][j][2]+1:1;
                    dp[i][j][3]=j+1<N?dp[i][j+1][3]+1:1;
                }
            }
        }
        int ans=1;
        for (int i = 1; i <N-1 ; i++) {
            if(N-i<=ans){
                break;
            }
            for (int j = 1; j <N-1 ; j++) {
                if(N-j<=ans){
                    break;
                }
                if(matrix[i][j]==1){
                    continue;
                }
                int curAns=Math.min(Math.min(Math.min(dp[i-1][j][0],dp[i][j-1][1]),dp[i+1][j][2]),dp[i][j+1][3]);
                ans=Math.max(ans,curAns);
            }
        }
        return ans;
    }
}
