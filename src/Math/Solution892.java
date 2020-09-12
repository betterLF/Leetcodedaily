package Math;

/**
 * @authtor liFei
 * @date 2020/9/9-13:32
 */
public class Solution892 {
    /*
    在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
请你返回最终形体的表面积。
     */
    int []row={0,-1,0,1};
    int []col={1,0,-1,0};
    public int surfaceArea(int[][] grid) {
         int ans=0;
        int N=grid.length;
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
            if(grid[i][j]>0){
                ans+=2;
                for (int k = 0; k <4 ; k++) {
                    int curX=i+col[k];
                    int curY=j+row[k];
                    if(curX<0||curX>=N||curY<0||curY>=N){
                        ans+=grid[i][j];
                    }else{
                        ans+=Math.max(0,grid[i][j]-grid[curX][curY]);
                    }
                }
            }
            }
        }
        return ans;
    }
}
