package BinarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/15-10:53
 */
public class Solution349 {
    /*
    给定两个数组，编写一个函数来计算它们的交集。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> arr=new HashSet<>();
        List<Integer> arr2=new ArrayList<>();
        for(int cur:nums1){
            arr.add(cur);
        }
        for(int cur:nums2){
            if(arr.contains(cur)&&!arr2.contains(cur)){
                arr2.add(cur);
            }
        }
       int res[]=new int[arr2.size()];
        for(int i=0;i<arr2.size();i++){
            res[i]=arr2.get(i);
        }
        return res;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);
        set1.retainAll(set2);//保留set2中有的元素
        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
