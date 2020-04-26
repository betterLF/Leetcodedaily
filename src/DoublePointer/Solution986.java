package DoublePointer;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/4/24-11:25
 */
/*
给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
返回这两个区间列表的交集。
（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，
要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<Integer> ans=new ArrayList<>();
        int len=B.length;
        int temp=0;
        for(int i=0;i<A.length;i++){
            temp=0;
             while (temp<len){
                 if(A[i][0]>B[temp][1]){
                     temp++;
                 }else if(A[i][1]<B[temp][0]){
                     break;
                 }else{
                         ans.add(Math.max(A[i][0],B[temp][0]));
                         ans.add(Math.min(A[i][1],B[temp][1]));
                         temp++;
                     }
                 }
             }
        int res[][]=new int[ans.size()/2][2];
        int row=0;
        for (int i=0;i<ans.size();i+=2){
            res[row][0]=ans.get(i);
            res[row][1]=ans.get(i+1);
            row++;
        }
        return res;
    }
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        ArrayList<int[]> ans=new ArrayList<>();
       int i=0;
       int j=0;
     while (i<A.length&&j<B.length){
         int left=Math.max(A[i][0],B[j][0]);
         int right=Math.min(A[i][1],B[j][1]);
         if(left<=right){
             ans.add(new int[]{left,right});

         }
         if(A[i][1]>B[j][1]){//如果A中该集合最大值大于B最大值，就j++，去找B中下一个集合是不是和A也有交集
             j++;
         }else{//否则，A中该集合不可能和B下一个集合有交集，所以i++;
             i++;
         }
     }
//        int res[][]=new int[ans.size()][2];
//        int row=0;
//        for (int []cur:ans){
//            res[row]=cur;
//            row++;
//        }
//        return res;
        return ans.toArray(new int[ans.size()][]);
    }
}
