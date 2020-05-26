package Math;

/**
 * @authtor liFei
 * @date 2020/5/24-10:10
 */
public class Solution172 {
    /*
    给定一个整数 n，返回 n! 结果尾数中零的数量。
     */
    public int trailingZeroes(int n) {
          int ans=0;
        while (n>0){
          ans+=n/5;
          n/=5;
        }
        return ans;
    }
}
