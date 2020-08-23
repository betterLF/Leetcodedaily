package Recursion;

/**
 * @authtor liFei
 * @date 2020/8/21-7:57
 */
public class Solution576 {
    /*
    给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
    或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。
    找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
     */
//    public int findPaths(int m, int n, int N, int i, int j) {
//        if(N==0) return 0;
//        int mod = 1000000007;
//        int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
//        int[][] dp = new int[m][n];
//        for(int k=0;k<N;k++){
//            int[][] tmp = new int[m][n];
//            for(int x=0;x<m;x++){
//                for(int y=0;y<n;y++){
//                    for(int[] d: direct){
//                        if(x+d[0]<0 || x+d[0]>=m || y+d[1]<0 || y+d[1]>=n){
//                            tmp[x][y]++;
//                        }else{
//                            tmp[x][y] = (tmp[x][y]+dp[x+d[0]][y+d[1]])%mod;
//                        }
//                    }
//                }
//            }
//            dp = tmp;
//        }
//        return dp[i][j];
//    }
    private final int COUNT=1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] label = new int[m][n][N+1];
        return find(m,n,N,i,j,label);
    }
    int find(int m, int n, int N, int i, int j,int[][][] label){
        if(N<0){
            return 0;
        }
        if(i + N < m && i - N >= 0 && j + N < n && j - N >= 0){//如果当前位置走无论如何到不了边界返回0
            return 0;
        }
        if(i<0||j<0||i>=m||j>=n){//当前到达边界返回1
            return 1;
        }
        else{
            if(label[i][j][N]!=0){//如果当前位置已经走过
                return label[i][j][N];
            }
            label[i][j][N]=((find(m,n,N-1,i+1,j,label)+find(m,n,N-1,i-1,j,label))%COUNT +(find(m,n,N-1,i,j+1,label)+find(m,n,N-1,i,j-1,label))%COUNT)%COUNT;
            return label[i][j][N];
        }
    }
}
