package Math;

/**
 * @authtor liFei
 * @date 2020/7/1-7:50
 */
public class Solution342 {
    /*
    给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
     */
    public boolean isPowerOfFour(int num) {
        //return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}
