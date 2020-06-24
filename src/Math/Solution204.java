package Math;

/**
 * @authtor liFei
 * @date 2020/6/21-9:23
 */
public class Solution204 {
    /*
    统计所有小于非负整数 n 的质数的数量。
     */
    //超限制
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }{
            int ans=1;//2为质数
            for (int i = 3; i <n ; i+=2) {
                if (!isRight(i)){
                    ans++;
                }
            }
            return ans;
        }
    }
    private boolean isRight(int n){
        for (int i = 3; i<n ; i+=2) {
            if(n%i==0){
                return true;
            }
        }
        return false;
    }
    public int countPrimes2(int n) {
        int result = 0;
        boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
        if(2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数

        for(int i = 3; i < n; i += 2){  // 从 3 开始遍历，且只遍历奇数，而且每次遍历都会把其对应的倍数变成true
            if(!b[i]){  // 如果当前遍历的是质数
                for(int j = 3; i * j < n; j += 2){
                    b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }

}
