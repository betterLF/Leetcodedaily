package Recursion;

/**
 * @authtor liFei
 * @date 2020/5/28-16:58
 */
public class Solution70 {
    /*
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
     */
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int []ans=new int[n+1];
        ans[1]=1;
        for (int i = 2; i <n+1 ; i++) {
            ans[i]=ans[i-1]+ans[i-2];
        }
       return   ans[n];
    }
    //递归超时间，因为有重复计算的楼层数
    private int countNum(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return countNum(n-1)+countNum(n-2);
    }
}
