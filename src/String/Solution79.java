package String;

/**
 * @authtor liFei
 * @date 2020/6/10-8:00
 */
public class Solution79 {
    /*
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。
     */
    boolean flag;
    public boolean exist(char[][] board, String word) {
        if(board.length==0){
            return false;
        }
        flag=false;
        boolean [][]f=new boolean[board.length][board[0].length];
        char[] w=word.toCharArray();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]==w[0]){
                    f[i][j]=true;
                    if(back(board,w,i,j,1,f)){
                        return true;
                    }
                    f[i][j]=false;
                }
            }
        }
        return false;
    }
    private boolean back(char [][]board,char[]w,int row,int column,int index,boolean[][]f){
        if(index==w.length){
            flag=true;
            return flag;
        }
        if(flag==true){
            return true;
        }
        if(row-1>=0&&board[row-1][column]==w[index]&&f[row-1][column]!=true){//上面可以走
               f[row-1][column]=true;
               back(board,w,row-1,column,index+1,f);
               f[row-1][column]=false;
        }

        if(row+1<board.length&&board[row+1][column]==w[index]&&f[row+1][column]!=true){//下面可以走
            f[row+1][column]=true;
            back(board,w,row+1,column,index+1,f);
            f[row+1][column]=false;
        }
        if(column-1>=0&&board[row][column-1]==w[index]&&f[row][column-1]!=true){//左面可以走
            f[row][column-1]=true;
            back(board,w,row,column-1,index+1,f);
            f[row][column-1]=false;
        }
        if(column+1<board[0].length&&board[row][column+1]==w[index]&&f[row][column+1]!=true){//右面可以走
            f[row][column+1]=true;
            back(board,w,row,column+1,index+1,f);
            f[row][column+1]=false;
        }
         return flag;
    }
}
