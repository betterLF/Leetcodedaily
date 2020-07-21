package Stack;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/7/22-6:48
 */
public class Solution496 {
    /*
    给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                int len=nums1.length;
                int []ans=new int[len];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums2.length ; i++) {
            map.put(nums2[i],i);
        }
        for (int i = 0; i <nums1.length ; i++) {
            int index=map.get(nums1[i]);
            ans[i]=getGreater(nums2,index);
        }
        return ans;
    }
    private int getGreater(int []nums2,int index){
        int cur=nums2[index];
        for (int i = index+1; i <nums2.length ; i++) {
            if(nums2[i]>cur){
                return nums2[i];
            }
        }
        return -1;
    }
}
