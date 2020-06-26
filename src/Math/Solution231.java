package Math;

/**
 * @authtor liFei
 * @date 2020/6/23-7:23
 */
public class Solution231 {
    /*
    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */
    public boolean isPowerOfTwo(int n) {
        int cur = 1;
        while (cur < n) {
            cur *= 2;
        }
        if (cur == n) {
            return true;
        } else {
            return false;
        }
    }
}