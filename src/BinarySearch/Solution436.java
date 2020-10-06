package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/7/26-8:49
 */
public class Solution436 {
    /*
    给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j
有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
注意:
你可以假设区间的终点总是大于它的起始点。
你可以假定这些区间都不具有相同的起始点。
     */
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int len=intervals.length;
        if(len==0){
            return new int[0];
        }
        int []ans=new int[len];
        for (int i = 0; i <len ; i++) {
            map.put(intervals[i][0],i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i <len ; i++) {
            ans[map.get(intervals[i][0])]=binarySearch(map,intervals,intervals[i][1]);
        }
        return ans;
    }
    private int binarySearch(HashMap<Integer,Integer> map,int [][]intervals,int target){
        int left=0;
        int right=intervals.length-1;
        if(intervals[right][0]<target){//不存在
            return -1;
        }
        while (left<right){
            int mid=left+(right-left)/2;
            if(intervals[mid][0]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return map.get(intervals[left][0]);
    }
}
