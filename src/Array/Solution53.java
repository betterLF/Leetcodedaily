package Array;

/**
 * @authtor liFei
 * @date 2020/6/8-8:41
 */
public class Solution53 {
    /*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {
             int len=nums.length;
             int []sum=new int[len];
             sum[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        int min=sum[0]>0?0:sum[0];
        int ans=sum[0];
        for (int i = 1; i <len ; i++) {
            ans=Math.max(ans,sum[i]-min);
            if(sum[i]<min){
                min=sum[i];
            }
        }
        return ans;
    }
}
