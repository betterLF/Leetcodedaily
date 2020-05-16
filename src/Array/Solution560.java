package Array;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/15-7:21
 */
public class Solution560 {
    /*
    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     */
    public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        int sum=0;
        HashMap<Integer,Integer> temp=new HashMap<>();
        temp.put(0,1);
        int ans=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(temp.containsKey(sum-k)){
                ans+=temp.get(sum-k);
            }
            temp.put(sum,temp.getOrDefault(sum,0)+1);

        }
        return ans;
    }
    public int subarraySum2(int[] nums, int k) {
        if(nums.length==0) return 0;
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){//遍历结束后得到前项和中最大值与最小值，并且原数组变成前i项和的数组
            nums[i]+=nums[i-1];
            max=max>nums[i]?max:nums[i];
            min=min<nums[i]?min:nums[i];
        }
        int count=0;
        int map[]=new int[max-min+1];//存放当前每个和出现次数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){//如果该和等于k，结果就+1
                count++;
            }
            if(nums[i]-k>=min&&nums[i]-k<=max){//如果前i项和-k在最小和最大值之间
                count+=map[nums[i]-k-min];//将遍历到i时nums[i]-k的个数加入结果集中
            }
            map[nums[i]-min]++;//该元素值加一
        }
        return count;
    }
}
