import java.util.ArrayList;
import java.util.List;
/*
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 */
public class Solution289 {
    public int m;
    public int n;
    //数组比集合更省时间！
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int res[]=new int[m*n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[count++]=judge(board, i, j);
            }
        }
        count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (res[count] < 2 || res[count] > 3) {
                        board[i][j] = 0;
                    }
                    count++;
                } else {
                   if(res[count]==3){
                       board[i][j]=1;
                   }
                   count++;
                }
            }
        }
    }
    private int judge(int [][]board,int i,int j){
        int count=0;//活细胞数目
        //按照左上，上，右上，左，右，左下，下，右下顺序判断
        if(i-1>=0&&j-1>=0){
            if(board[i-1][j-1]==1){
                count++;
            }
        }
        if(i-1>=0){
            if(board[i-1][j]==1){
                count++;
            }
        }
        if(i-1>=0&&j+1<n){
            if(board[i-1][j+1]==1){
                count++;
            }
        }
        if(j-1>=0){
            if(board[i][j-1]==1){
                count++;
            }
        }
        if(j+1<n){
            if(board[i][j+1]==1){
                count++;
            }
        }
        if(i+1<m&&j-1>=0){
            if(board[i+1][j-1]==1){
                count++;
            }
        }
        if(i+1<m){
            if(board[i+1][j]==1){
                count++;
            }
        }
        if(i+1<m&&j+1<n){
            if(board[i+1][j+1]==1){
                count++;
            }
        }
        return count;
    }
}
