package Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/17-9:28
 */
public class Solution1403 {
    /*
给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int sum[]=new int[len];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        List<Integer> res=new LinkedList<>();
        res.add(nums[len-1]);
        if(len==1){
            return res;
        }
        int count=nums[len-1];
        int m=len-2;
        int n=len-2;
        while(count<=sum[m]){
            res.add(nums[n]);
            count+=nums[n];
            if(m==0){
                break;
            }
            n--;
            m--;
        }
        return res;
    }
}
