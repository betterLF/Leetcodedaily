package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/6/20-7:44
 */
public class Solution200 {
    /*
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
     char [][]clone= grid.clone();
     int ans=0;
        for (int i = 0; i <clone.length ; i++) {
            for (int j = 0; j <clone[0].length ; j++) {
               if(clone[i][j]=='1'){
                   clone[i][j]='0';
                   dfs(clone,i,j);
                   ans++;
               }
            }
        }
        return ans;
    }
    private void dfs(char [][]clone,int row,int column){
        if(row-1>=0&&clone[row-1][column]=='1'){
            clone[row-1][column]='0';
            dfs(clone,row-1,column);
        }
        if(row+1<clone.length&&clone[row+1][column]=='1'){
            clone[row+1][column]='0';
            dfs(clone,row+1,column);
        }
        if(column-1>=0&&clone[row][column-1]=='1'){
            clone[row][column-1]='0';
            dfs(clone,row,column-1);
        }
        if(column+1<clone[0].length&&clone[row][column+1]=='1'){
            clone[row][column+1]='0';
            dfs(clone,row,column+1);
        }
    }
}
