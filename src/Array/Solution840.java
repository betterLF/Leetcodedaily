package Array;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/9/7-7:21
 */
public class Solution840 {
/*
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 */
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        for (int i = 0; i <grid.length-2 ; i++) {
            for (int j = 0; j <grid[0].length-2 ; j++) {
                if(isTrue(grid,i,j)){
                ans++;
                }
            }
        }
        return ans;
    }
    private boolean isTrue(int [][]grid,int leftRow,int leftCol){
        if(grid[leftRow+1][leftCol+1]!=5){
            return false;
        }
        HashSet<Integer> set=new HashSet<>();
        for (int i = leftRow; i <leftRow+3 ; i++) {
            for (int j = leftCol; j <leftCol+3 ; j++) {
                if(set.contains(grid[i][j])){
                    return false;
                }else if(grid[i][j]>=10||grid[i][j]<=0) {
                return false;
                }else{
                    set.add(grid[i][j]);
                }
            }
        }
        int ans=grid[leftRow][leftCol]+grid[leftRow][leftCol+1]+grid[leftRow][leftCol+2];
        for (int i = 1; i <=2 ; i++) {
            int cur=grid[leftRow+i][leftCol]+grid[leftRow+i][leftCol+1]+grid[leftRow+i][leftCol+2];
            if(cur!=ans){
                return false;
            }
        }
        for (int i = 0; i <3 ; i++) {
            int cur=grid[leftRow][leftCol+i]+grid[leftRow+1][leftCol+i]+grid[leftRow+2][leftCol+i];
            if(cur!=ans){
                return false;
            }
        }
        return ans==grid[leftRow][leftCol]+grid[leftRow+1][leftCol+1]+grid[leftRow+2][leftCol+2]&&ans==grid[leftRow][leftCol+2]+grid[leftRow+1][leftCol+1]+grid[leftRow+2][leftCol];
    }
}
