package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/2-6:53
 */
public class Solution350 {
    /*
    给定两个数组，编写一个函数来计算它们的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<=nums2.length){
            return getAns(nums1,nums2);
        }else{
            return getAns(nums2,nums1);
        }

    }
    private int[] getAns(int []n1,int []n2){//保证n1.length<=n2.length
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <n1.length ; i++) {
            map.put(n1[i],map.getOrDefault(n1[i],0)+1);
        }
        int count=n1.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <n2.length ; i++) {
            if(count==0){
                break;
            }
            if(map.containsKey(n2[i])) {
                int cur = map.get(n2[i]);
                if (cur != 0) {
                    list.add(n2[i]);
                    map.put(n2[i], cur-1);
                    count--;
                }
            }
        }
        int []ans=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer> list=new ArrayList<>();
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int []ans=new int[list.size()];
        for (int k= 0; k <list.size() ; k++) {
            ans[k]=list.get(k);
        }
        return ans;

    }
}
