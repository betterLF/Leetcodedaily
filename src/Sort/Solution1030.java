package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/4/17-7:56
 */
public class Solution1030 {
    /*
给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，
两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
     */
    public static void main(String[] args) {
        allCellsDistOrder3(1,2,0,0);
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
         int ans[][]=new int[R*C][2];
         PriorityQueue<int[]> res=new PriorityQueue<>((n1, n2)->distance(n1[0],n1[1],r0,c0)-distance(n2[0],n2[1],r0,c0)) ;
         for(int i=0;i<R;i++){
             for(int j=0;j<C;j++){
                 int a[]={i,j};
                 res.add(a);
             }
         }
        for(int i=0;i<R*C;i++){
             ans[i][0]= res.peek()[0];
             ans[i][1]=res.poll()[1];
        }
        return ans;
    }
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {//数组更快
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i*C+j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            return  distance(arr1[0], arr1[1], r0, c0)-distance(arr2[0], arr2[1], r0, c0);
        });

        return re;
    }
    public static int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {//桶排序
        int max=Math.max(R-1-r0,r0)+Math.max(C-1-c0,c0);
         ArrayList<ArrayList<int[]>> res=new ArrayList<>();
         for(int i=0;i<=max;i++){
             res.add(new ArrayList<>());
         }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int a[]={i,j};
                 res.get(distance(i,j,r0,c0)).add(a);
            }
        }
        int ans[][]=new int[R*C][2];
        int count=0;
        for(int i=0;i<=max;i++){
            List<int []> cur=res.get(i);
            for (int j=0;j<cur.size();j++){
                ans[count][0]=cur.get(j)[0];
                ans[count++][1]=cur.get(j)[1];
            }
        }
        return ans;
    }
    private static int distance(int i,int j,int r0,int c0){
        return Math.abs(i-r0)+Math.abs(j-c0);
    }


}
