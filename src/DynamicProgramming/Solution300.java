package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/6/3-17:38
 */
public class Solution300 {
    /*
    给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len==0){
            return 0;
        }
        int []dp=new int[len];
        dp[0]=1;
        int max=1;
        for (int i = 1; i <len ; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(dp[i],max);
                }
            }
            if(dp[i]==0){
                dp[i]=1;
            }
        }
        return max;
    }
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];//下标位置代表最长子序列为n时的元素最小值
        int len = 1;//代表当前的最长子序列元素个数
        dp[1] = nums[0];
        for (int i = 1; i < n; i++){
            int l = 1;
            int r = len;
            if (nums[i] > dp[len]) {//如果当前元素大于最长子序列的最后一个元素
                dp[++len] = nums[i];//最长子序列加一，而且其值为nums[i]
            }else{
                while (l <= r){//找到一个dp值，其值大于nums[i]
                    int mid = (l + r) / 2;
                    if (dp[mid] < nums[i]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                dp[l] = nums[i];
            }
        }
        return len;
    }
}
