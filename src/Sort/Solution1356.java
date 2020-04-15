package Sort;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/15-11:03
 */
public class Solution1356 {
    /*
    给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
    如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
    请你返回排序后的数组。
     */
    public int[] sortByBits(int[] arr) {
        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                    return hammingWeight((int)o1)-hammingWeight((int)o2);
                }
        };
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(arr);
        for(int cur:arr){
            ans.add(cur);
        }
     Collections.sort(ans,c);
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return  res;
    }
    private static int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }
}
