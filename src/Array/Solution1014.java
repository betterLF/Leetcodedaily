package Array;

/**
 * @authtor liFei
 * @date 2020/6/17-9:58
 */
public class Solution1014 {
    /*
    给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
返回一对观光景点能取得的最高分。
     */
    public static void main(String[] args) {
        int []test={8,1,5,2,6};
        maxScoreSightseeingPair(test);
    }
    public static int maxScoreSightseeingPair(int[] A) {
        int len=A.length;
           int []sum=new int[len];
        for (int i = 0; i <len ; i++) {//sumi代表每个景点减去距离0处后的评分
            sum[i]=A[i]-i;
        }
        int []max=new int[len-1];//i代表剩余i+1个元素中的最大值
        max[0]=sum[len-1];
        int count=1;
        for (int i = len-2; i>=1 ; i--) {
            max[count]=Math.max(max[count-1],sum[i]);
            count++;
        }
        int ans=0;
        for (int i = 0; i <len-1 ; i++) {
            ans=Math.max(ans,2*i+sum[i]+max[len-2-i]);
        }
        return ans;
    }
    public int maxScoreSightseeingPair2(int[] A) {
        int ans = 0, mx = A[0] + 0;//为当前最大的收益
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);//之前的最大收益加上当前该位置收益
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }

}
