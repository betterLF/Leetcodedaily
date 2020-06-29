package Array;

/**
 * @authtor liFei
 * @date 2020/6/26-8:40
 */
public class Solution209 {
    /*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     */
    public static void main(String[] args) {
        int a[]={2,3,1,2,4,3};
        minSubArrayLen(7,a);
    }
    public static int minSubArrayLen(int s, int[] nums) {
         if(nums.length==0){
             return 0;
         }
        int left=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            while(sum>=s){//得到以left下标为起点满足条件的最小子数组
                ans=Math.min(ans,i-left+1);//与当前结果相比
                sum-=nums[left];//将该起点移除
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
