package HashTable;

/**
 * @authtor liFei
 * @date 2020/4/29-6:45
 */
public class Solution463 {
    /*
    给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿
（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     */
    public int islandPerimeter(int[][] grid) {
        int count=0;
        int len1=grid.length;
        int len2=grid[0].length;
        for (int i = 0; i <len1; i++) {
            for (int j=0;j<len2;j++){
                if(grid[i][j]==1){
                 count+=num(grid,i,j);
                }
            }
        }
        return count;
    }
    private int num(int [][]gird,int i,int j){
        int temp=0;
        if(i-1>=0&&gird[i-1][j]==1){
            temp++;
        }
        if(j-1>=0&&gird[i][j-1]==1){
            temp++;
        }
        if(i+1<gird.length&&gird[i+1][j]==1){
            temp++;
        }
        if(j+1<gird[0].length&&gird[i][j+1]==1){
            temp++;
        }
        return 4-temp;
    }
}
