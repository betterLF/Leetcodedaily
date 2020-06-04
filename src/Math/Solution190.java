package Math;

/**
 * @authtor liFei
 * @date 2020/6/2-18:44
 */
public class Solution190 {
    /*
    颠倒给定的 32 位无符号整数的二进制位。
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
                int ans=0;
        for (int i = 0,j=31; i <32 ; i++) {
            int cur=(1<<i);
            if((n&cur)!=0){
                ans|=(1<<j);
            }
            j--;
        }
        return ans;
    }
}
