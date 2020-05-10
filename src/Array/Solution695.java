package Array;

/**
 * @authtor liFei
 * @date 2020/5/9-6:07
 */
public class Solution695 {
    /*
    给定一个包含了一些 0 和 1 的非空二维数组 grid 。
一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。
找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     */
    public static void main(String[] args) {
int a[][]={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
maxAreaOfIsland(a);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,getArea(grid,i,j));
                }
            }
        }
        return max;
    }
    private static int getArea(int gird[][],int r,int c){
              if(r<0||c<0||r>=gird.length||c>=gird[0].length||gird[r][c]==0){
                  return 0;
              }
              int area=1;
              gird[r][c]=0;
            area+=getArea(gird,r-1,c);
            area+=getArea(gird,r,c-1);
            area+=getArea(gird,r+1,c);
            area+=getArea(gird,r,c+1);
        return area;
    }
}
