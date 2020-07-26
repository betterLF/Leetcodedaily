package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/23-6:28
 */
public class Solution417 {
    /*
    给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
                  int m=matrix.length;
                  if(m==0){
                      return new ArrayList<>();
                  }
                  int n=matrix[0].length;
                  boolean [][]left=new boolean[m][n];
                  boolean [][]right=new boolean[m][n];
                  //left
        for (int i = 0; i <m ; i++) {
            left[i][0]=true;
        }
        for (int i = 0; i <n ; i++) {
            left[0][i]=true;
        }
        boolean [][]visited01=new boolean[m][n];
        for (int i = 0; i <n; i++) {
            if(visited01[0][i]){
                continue;
            }
            visited01[0][i]=true;
            getLeft(visited01,left,matrix,0,i);
        }
        for (int i = 0; i <m ; i++) {
            if(visited01[i][0]){
                continue;
            }
            visited01[i][0]=true;
            getLeft(visited01,left,matrix,i,0);
        }

        for (int i = 0; i <m ; i++) {
           right[i][n-1]=true;
        }
        for (int i = 0; i <n ; i++) {
            right[m-1][i]=true;
        }
        boolean [][]visited02=new boolean[m][n];
        for (int i = m-1; i>=0 ; i--) {
            if(visited02[i][n-1]){
                continue;
            }
            visited02[i][n-1]=true;
            getLeft(visited02,right,matrix,i,n-1);
        }
        for (int i = n-1; i >=0 ; i--) {
            if(visited02[m-1][i]){
                continue;
            }
            visited02[m-1][i]=true;
            getLeft(visited02,right,matrix,m-1,i);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(left[i][j]&&right[i][j]){
                    ArrayList<Integer> cur=new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
    private void getLeft(boolean [][]visited,boolean [][]left,int [][]matrix,int i,int j){
        if(j+1<matrix[0].length&&visited[i][j+1]==false&&matrix[i][j+1]>=matrix[i][j]){
            left[i][j+1]=true;
            visited[i][j+1]=true;
            getLeft(visited,left,matrix,i,j+1);
        }
        if(i+1<matrix.length&&visited[i+1][j]==false&&matrix[i+1][j]>=matrix[i][j]){
            left[i+1][j]=true;
            visited[i+1][j]=true;
            getLeft(visited,left,matrix,i+1,j);
        }
        if(j-1>=0&&visited[i][j-1]==false&&matrix[i][j-1]>=matrix[i][j]){
            left[i][j-1]=true;
            visited[i][j-1]=true;
            getLeft(visited,left,matrix,i,j-1);
        }
        if(i-1>=0&&visited[i-1][j]==false&&matrix[i-1][j]>=matrix[i][j]){
            left[i-1][j]=true;
            visited[i-1][j]=true;
            getLeft(visited,left,matrix,i-1,j);
        }
    }
}
