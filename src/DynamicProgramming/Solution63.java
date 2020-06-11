package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/6/9-7:35
 */
public class Solution63 {
    /*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     */
    //回溯超限制
    public int ans;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int endRow=obstacleGrid.length-1;
        int endColumn=obstacleGrid[0].length-1;
        ans=0;
        if(obstacleGrid[0][0]==1||obstacleGrid[endRow][endColumn]==1){
            return ans;
        }
        getPath(obstacleGrid,0,0,endRow,endColumn);
        return ans;
    }
    private void getPath(int [][]obstacleGrid,int row,int coulmn,int endRow,int endColumn){
          if(row==endRow&&coulmn==endColumn){
              ans++;
              return;
          }
          if(row>endRow||coulmn>endColumn||obstacleGrid[row][coulmn]==1){//剪枝
              return;
          }
          getPath(obstacleGrid,row+1,coulmn,endRow,endColumn);
          getPath(obstacleGrid,row,coulmn+1,endRow,endColumn);
    }
    //动态规划
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
        int [][]dp=new int[r][c];//代表到达该点的路径数
        dp[0][0]=1;
        if(obstacleGrid[0][0]==1||obstacleGrid[r-1][c-1]==1){//如果出发点和末尾都有障碍物，返回false。
            return 0;
        }
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(obstacleGrid[i][j]==1){//如果有障碍物，该点可到达为0
                    continue;
                }
                if(i-1>=0){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j-1>=0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[r-1][c-1];
    }
}
