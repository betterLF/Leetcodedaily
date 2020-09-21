package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/9/18-5:38
 */
public class Solution688 {
    /*

已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
求移动结束后，“马” 仍留在棋盘上的概率。
     */
    int [][]m=new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    double [][][]dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp=new double[K+1][N][N];
         return move(N,r,c,K);
    }
    private double move(int N,int r,int c,int cur_K){
        if(!(c>=00&&c<N)&&(r>=0&&r<N)){//表示此路不通
            return 0;
        }
        if(dp[cur_K][r][c]!=0){
            return dp[cur_K][r][c];
        }
        if(cur_K==0) {//表示已经走完
            return 1;
        }
        double ans=0;
        for (int i = 0; i <8 ; i++) {
            int rr=r+m[i][0];
            int cc=c+m[i][1];
            ans+=move(N, rr, cc, cur_K-1);
            }
        ans/=8;
        dp[cur_K][r][c]=ans;
        return ans;
    }
//    public double knightProbability(int N, int K, int sr, int sc) {
//        double[][] dp = new double[N][N];
//        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
//        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
//
//        dp[sr][sc] = 1;
//        for (; K > 0; K--) {
//            double[][] dp2 = new double[N][N];
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) {
//                    for (int k = 0; k < 8; k++) {
//                        int cr = r + dr[k];
//                        int cc = c + dc[k];
//                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
//                            dp2[cr][cc] += dp[r][c] / 8.0;
//                        }
//                    }
//                }
//            }
//            dp = dp2;
//        }
//        double ans = 0.0;
//        for (double[] row : dp) {
//            for (double x : row) ans += x;
//        }
//        return ans;
//    }
}
