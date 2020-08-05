package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/8/3-7:01
 */
public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int len=nums.length;
          int [][]dp=new int[len+1][len];//dp[i][j]代表在i到j区间里选手能获得的最大分差
        for (int i = len; i>=0 ; i--) {
            for (int j = i+1; j <len ; j++) {
                     int a=nums[i]-dp[i+1][j];//即你选了第i个数时-下一个玩家在i+1->j中的最大值，得到此时的差值
                     int b=nums[j]-dp[i][j-1];
                     dp[i][j]=Math.max(a,b);
            }
        }
        return dp[0][len-1]>=0;
    }
    public boolean PredictTheWinner2(int[] nums) {
         return dfs(0,nums.length-1,0,0,true,nums);
    }
    private boolean dfs(int left,int right,int aNum,int bNum,boolean isA,int []nums){
        if(left>right){
            return aNum>=bNum;
        }
        if(isA){//如果是A的回合
            return dfs(left+1,right,aNum+nums[left],bNum,false,nums)||dfs(left,right-1,aNum+nums[right],bNum,false,nums);
        }else{
            return dfs(left+1,right,aNum,bNum+nums[left],true,nums)&&dfs(left,right-1,aNum,bNum+nums[right],true,nums);
        }
    }
}
