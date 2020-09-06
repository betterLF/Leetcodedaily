package Bitwise;

/**
 * @authtor liFei
 * @date 2020/9/4-11:31
 */
public class Solution762 {
    /*
    给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     */
    public int countPrimeSetBits(int L, int R) {
             int ans=0;
        for (int i = L; i <=R ; i++) {
          if(isPrime(Integer.bitCount(i))){
              ans++;
          }
        }
        return ans;
    }
    private boolean isPrime(int count){
        return count==2||count==3||count==5||count==7||count==11||count==13||count==17||count==19;
    }
}
