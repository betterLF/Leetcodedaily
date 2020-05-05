package Sort;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/5/3-8:06
 */
public class Solution56 {
    /*
    给出一个区间的集合，请合并所有重叠的区间。
     */
    public int[][] merge(int[][] intervals) {
        List<int []> ans=new ArrayList<>();
        if(intervals.length==0){
            int a[][]={};
            return a;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        int start=intervals[0][0];
        int end=intervals[0][1];
        boolean flag=true;
        for (int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
                flag=true;
            }else{
                int cur[]={start,end};
                ans.add(cur);
                start=intervals[i][0];
                end=intervals[i][1];
                flag=false;
            }
        }
        if (flag==true||start==intervals[intervals.length-1][0]){
            int cur[]={start,end};
            ans.add(cur);
        }
        int res[][]=ans.toArray(new int[ans.size()][2]);
        return res;
    }
}
