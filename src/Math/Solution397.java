package Math;

/**
 * @authtor liFei
 * @date 2020/7/14-9:16
 */
public class Solution397 {
    /*
给定一个正整数 n，你可以做如下操作：
1. 如果 n 是偶数，则用 n / 2替换 n。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
n 变为 1 所需的最小替换次数是多少？
     */
    public int integerReplacement(int n) {
        if(n==1){
            return 0;
        }
        if (n == Integer.MAX_VALUE) {//溢出排除
            return 32;
        }
          if(n%2==0){
              return integerReplacement(n/2)+1;
          }else{
              if(n==3){
                  return 2;
              }
              if((n+1)%4==0){
                  return integerReplacement(n+1)+1;
              }else{
                  return integerReplacement(n-1)+1;
              }
          }
    }
}
