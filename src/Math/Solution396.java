package Math;

/**
 * @authtor liFei
 * @date 2020/7/14-8:56
 */
public class Solution396 {
    /*
    给定一个长度为 n 的整数数组 A 。
假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
计算F(0), F(1), ..., F(n-1)中的最大值。
     */
    public int maxRotateFunction(int[] A) {
         int sum1=0;
         int sum2=0;
        int len=A.length;
        for (int i = 0; i <len ; i++) {
            sum1+=A[i];
          sum2+=i*A[i];
        }
        int temp=len-1;
        int ans=sum2;
        while (temp>=0){
          sum2+=sum1-len*A[temp];
          ans=Math.max(ans,temp);
            temp--;
        }
        return ans;
    }
}
