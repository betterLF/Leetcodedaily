package Math;

/**
 * @authtor liFei
 * @date 2020/7/10-8:45
 */
public class Solution372 {
    /*
你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
     */
    public int superPow(int a, int[] b) {
        long temp = 0;
        for (int i = 0; i < b.length; i++) {
            temp = temp * 10 + b[i];
        }
        a %= 1337;
        int ans = a;
        for (int i = 1; i < temp; i++) {
            ans *= a;
            ans %= 1337;
        }
        return ans;
    }

    //欧拉函数
    public int superPow2(int a, int[] b) {
        int numB = b[0];
        a = a % 1337;
        if (a == 0) {
            return 0;
        }
        for (int i = 1; i < b.length; i++) {
            numB = (numB * 10 + b[i]) % 1140;//1140为1337对应的欧拉函数值
        }
        numB += 1140;
        int ans = a;
        for (int j = 1; j < numB; j++) {
            ans *= a;
            ans %= 1337;
        }
        return ans;
    }
}


