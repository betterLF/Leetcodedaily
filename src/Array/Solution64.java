package Array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/5/5-7:58
 */
public class Solution64 {
    /*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
     */
    public static void main(String[] args) {
        int a[][]= {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        minPathSum2(a);

    }
    public static int minPathSum(int[][] grid) {//递归超内存限制
         int right=grid[0].length-1;
         int down=grid.length-1;
         int sum=grid[0][0];
        Queue<Integer> ans=new PriorityQueue<>();
        getLength(ans,sum,down,right,grid);
        return ans.poll();

    }
    private static void getLength(Queue<Integer> ans,int sum,int down,int right,int grid[][]){
        if(down==0&&right==0){
            ans.add(sum);
            return;
        }
        if(down==0&&right!=0){
            sum+=grid[grid.length-1][grid[0].length-right];
            right--;
            getLength(ans,sum,down,right,grid);
        }else if(down!=0&&right==0){
            sum+=grid[grid.length-down][grid[0].length-1];
            down--;
            getLength(ans,sum,down,right,grid);
        }else{
            int temp=sum;
            sum=temp+grid[grid.length-down-1][grid[0].length-right];
            right--;
            getLength(ans,sum,down,right,grid);
            right++;
            sum=temp+grid[grid.length-down][grid[0].length-right-1];
            down--;
            getLength(ans,sum,down,right,grid);
        }
    }
    public static int minPathSum2(int[][] grid) {//4ms
        int ans[][]=new int[grid.length][grid[0].length];
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i-1>=0&&j-1>=0){
                    ans[i][j]=Math.min(ans[i-1][j]+grid[i][j],ans[i][j-1]+grid[i][j]);
                }else if(i-1>=0&&j-1<0){
                    ans[i][j]=ans[i-1][j]+grid[i][j];
                }else if(i-1<0&&j-1>=0){
                    ans[i][j]=ans[i][j-1]+grid[i][j];
                }else{
                    ans[0][0]=grid[0][0];
                }
            }
        }
        return ans[m-1][n-1];
    }

}
