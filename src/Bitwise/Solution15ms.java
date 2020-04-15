package Bitwise;

/**
 * @authtor liFei
 * @date 2020/4/15-9:15
 */
public class Solution15ms {
    /*
    请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
    有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */
    public static void main(String[] args) {
        hammingWeight(1111111101);
    }
    public static int hammingWeight(int n) {
          int count=0;
          while(n!=0){
             count+=n&1;
             n>>>=1;
          }
          return count;
    }
}
