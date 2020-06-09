package Array;

/**
 * @authtor liFei
 * @date 2020/6/6-8:11
 */
public class Solution36 {
    /*
    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     */

    public boolean isValidSudoku(char[][] board) {
        int [][]row=new int[9][9];
        int [][]column=new int[9][9];
        int [][]ge=new int[9][9];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                char cur=board[i][j];
                if(cur!='.'){
                   int temp=cur-'1';
                   if(row[temp][i]!=0){//判断行重复
                       return false;
                }else{
                       row[temp][i]=1;
                   }
                   if(column[temp][j]!=0){//判断列重复
                       return false;
                   }else{
                       column[temp][j]=1;
                   }
                   int curGe=j/3*3+i/3;
                   if(ge[temp][curGe]!=0){
                       return false;
                   }else{
                       ge[temp][curGe]=1;
                   }
            }
        }
    }
        return true;
    }
}
