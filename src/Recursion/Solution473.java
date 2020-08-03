package Recursion;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/31-6:51
 */
public class Solution473 {
    /*
    还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。
    不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     */
    private int bitwise;
    public boolean makesquare(int[] nums) {
        bitwise=0;
        int sum=0;
        for (int cur:nums){
            sum+=cur;
        }
        if(sum%4!=0){
            return false;
        }
        int count=0;
        Arrays.sort(nums);
        while (dfs(sum/4,nums.length-1,nums)&&count<3){
            System.out.println(bitwise);
            count++;
        }
        if(count==3){
            return true;
        }
        return false;
    }
    private boolean dfs(int target,int curIndex,int []nums){
        if(target==0){//如果达到目标值，返回true
            return true;
        }
        if(curIndex==-1){//如果到达末尾，返回false
            return false;
        }
        for (int i = curIndex; i>=0 ; i--) {
            if(target-nums[i]*(i+1)>0){
                break;
            }
            if((bitwise&(1<<i))==0){//如果没有被访问过
                int cur=bitwise;
                bitwise|=(1<<i);//标记已经访问
                if(dfs(target-nums[i], i-1, nums)){
                    return true;
                }
                bitwise=cur;//还原
            }
        }
        return false;
    }
}
