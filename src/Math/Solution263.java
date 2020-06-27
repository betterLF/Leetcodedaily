package Math;

/**
 * @authtor liFei
 * @date 2020/6/24-8:48
 */
public class Solution263 {
    /*
编写一个程序判断给定的数是否为丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。
     */
    public boolean isUgly(int num) {
       long cur=num;
       if(cur==0){
           return false;
       }
      while (cur%5==0){
          cur/=5;
      }
        while (cur%3==0){
            cur/=3;
        }
        while (cur%2==0){
            cur/=2;
        }
         return cur==1?true:false;
    }
}
