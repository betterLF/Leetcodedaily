package Array;

/**
 * @authtor liFei
 * @date 2020/6/14-16:56
 */
public class Solution130 {
    /*
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
             int m=board.length;
             int n=board[0].length;
        for (int i = 0; i <n; i++) {
            if (board[0][i] == 'O') {
                bfs(board,0,i);
            }
            if (board[m - 1][i] == 'O') {
               bfs(board,m-1,i);
            }
        }
        for (int i = 0; i <m ; i++) {
         if(board[i][0]=='O'){
           bfs(board,i,0);
         }
         if(board[i][n-1]=='O'){
           bfs(board,i,n-1);
         }
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(board[i][j]=='o'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
        return;
    }
    private void bfs(char [][]board,int row,int column){
        board[row][column]='o';
        if(row+1<board.length&&board[row+1][column]=='O'){
            bfs(board,row+1,column);
        }
        if(row-1>=0&&board[row-1][column]=='O'){
            bfs(board,row-1,column);
        }
        if(column+1<board[0].length&&board[row][column+1]=='O'){
            bfs(board,row,column+1);
        }
        if(column-1>=0&&board[row][column-1]=='O'){
            bfs(board,row,column-1);
        }
    }
}
