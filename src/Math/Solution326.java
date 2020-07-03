package Math;

/**
 * @authtor liFei
 * @date 2020/7/1-7:38
 */
public class Solution326 {
    /*
    给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     */
    public boolean isPowerOfThree(int n) {
               while (n>=3){
                   int temp=n%3;
                   if(temp!=0){
                       return false;
                   }
                   n/=3;
               }
               return n==1;
//        return n > 0 && 1162261467 % n == 0;
    }
}
