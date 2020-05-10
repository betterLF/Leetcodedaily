package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/9-6:42
 */
public class Solution1260 {
    /*
    给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
每次「迁移」操作将会引发下述活动：
位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        int ans[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
            int temp=i*column+j+k;
            if(temp>row*column){
                temp-=row*column;
            }
            ans[temp/column][temp%column]=grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                a.add(ans[i][j]);
            }
            res.add(a);
        }
        return res;
    }
}
