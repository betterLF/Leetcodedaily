package Recursion;

/**
 * @authtor liFei
 * @date 2020/7/23-7:36
 */
public class Solution419 {
    /*
    给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。。
     */
    public int countBattleships(char[][] board) {
                  int ans=0;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]=='X'){
                    if((i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
