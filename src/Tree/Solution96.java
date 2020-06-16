package Tree;

/**
 * @authtor liFei
 * @date 2020/6/12-16:04
 */
public class Solution96 {
    /*
    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */
//    public static void main(String[] args) {
//        System.out.println(numTrees(4));
//    }
    //仿照95题，超限制，因为n的个数大于8
    public static int numTrees(int n) {
          if(n==0){
              return 0;
          }else{
              return Back(1,n);
          }
    }
    private static int Back(int start,int end){
        int ans=0;
        if(start>end){
            return 1;
        }
        for (int i = start; i <=end ; i++) {
            int left=Back(start,i-1);
            int right=Back(i+1,end);
            ans+=left*right;
        }
        return ans;
    }
    public static int numTrees2(int n) {
        if(n==0){
            return 0;
        }
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
