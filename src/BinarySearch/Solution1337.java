package BinarySearch;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/5/2-8:19
 */
public class Solution1337 {
    /*
    给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 1 和 0 表示。
请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
     */
    public static void main(String[] args) {
        int mat[][]={{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1} };
        kWeakestRows(mat,3);
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        List<int []> ans=new LinkedList<>();
        for (int i=0;i<mat.length;i++){
            int cur[]={getOneNumber(mat[i],0,mat[0].length-1),i};
            ans.add(cur);
        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int res[]=new int[k];
        for (int i=0;i<k;i++){
            res[i]=ans.get(i)[1];
        }
        return res;
    }
    private static int getOneNumber(int row[],int left,int right){
        while (left<=right){
            int mid=left+(right-left)/2;
            if(row[mid]==1&&((mid+1<row.length&&row[mid+1]==0)||mid+1==row.length)){
                  return mid+1;
            }else if(row[mid]==0){
                right=mid-1;
            }else{
               left=mid+1;
            }
        }
        return 0;
    }
}
