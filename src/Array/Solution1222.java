package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/7-6:44
 */
public class Solution1222 {
    /*
    在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
     */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
             int arr[][]=new int[8][8];
             for (int i=0;i<queens.length;i++){
                 arr[queens[i][0]][queens[i][1]]=1;
             }
                  return getNumber(arr,king);
    }
    private List<List<Integer>> getNumber(int arr[][],int king[]){
        //横着
        List<List<Integer>> ans=new ArrayList<>();
        int row=king[0];
        int column=king[1];
        for (int i=column+1;i<8;i++){
            if(arr[row][i]==1){
                 add(ans,row,i);
                 break;
            }
        }
        for (int i=column-1;i>=0;i--){
            if(arr[row][i]==1){
                add(ans,row,i);
                break;
            }
        }
        //竖着
        for (int i=row+1;i<8;i++){
            if(arr[i][column]==1){
                add(ans,i,column);
                break;
            }
        }
        for (int i=row-1;i>=0;i--){
            if(arr[i][column]==1){
                add(ans,i,column);
                break;
            }
        }
        //对角线
        for(int i=row-1,j=column-1;j>=0&&i>=0;j--,i--){
            if(arr[i][j]==1){
                add(ans,i,j);
                break;
            }
        }
        for(int i=row+1,j=column+1;j<8&&i<8;j++,i++){
            if(arr[i][j]==1){
                add(ans,i,j);
                break;
            }
        }
        for(int i=row-1,j=column+1;j<8&&i>=0;j++,i--){
            if(arr[i][j]==1){
                add(ans,i,j);
                break;
            }
        }
        for(int i=row+1,j=column-1;j>=0&&i<8;j--,i++){
            if(arr[i][j]==1){
                add(ans,i,j);
                break;
            }
        }
          return ans;
    }
    private void add(List<List<Integer>> ans,int row,int column){
        List<Integer> temp=new ArrayList<>();
        temp.add(row);
        temp.add(column);
        ans.add(temp);
    }
}
