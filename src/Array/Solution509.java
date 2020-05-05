package Array;

/**
 * @authtor liFei
 * @date 2020/5/4-8:48
 */
public class Solution509 {
    /*
    斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
    该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。
     */
    public int fib(int N) {
            return f(N);
    }
    public int f(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return f(N - 1) + f(N - 2);
        }
    }
    public int fib2(int N) {
        if(N<=1){
            return N;
        }
        int fist=0;
        int second=1;
        for(int i=2;i<=N;i++){
            second+=fist;
            fist=second-fist;
        }
        return second;
    }
}
