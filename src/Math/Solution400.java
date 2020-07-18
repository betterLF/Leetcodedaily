package Math;

/**
 * @authtor liFei
 * @date 2020/7/15-7:47
 */
public class Solution400 {
    /*
    在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
注意:
n 是正数且在32位整数范围内 ( n < 2^31）
     */
    public int findNthDigit(int n) {
           long temp=9;
           int count=1;
           while (n>0){
               if(temp*count>=n){
                   long div=n/count;
                   long yu=n%count;
                   long start=(int)Math.pow(10,count-1);//开始的位置
                   if(yu==0){
                       long  ans=start+div-1;
                       return Long.toString(ans).charAt(count-1)-48;
                   }
                   long ans=start+div;
                   return Long.toString(ans).charAt((int)yu-1)-48;
//                   long num=temp/9+(n-1)/count;
//                   return Long.toString(num).charAt((n-1)%count)-'0';
               }else{
                   n-=temp*count;
                   temp*=10;
                   count++;
               }
           }
           return -1;
    }
}
