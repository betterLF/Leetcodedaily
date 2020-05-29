package Math;

/**
 * @authtor liFei
 * @date 2020/5/28-6:17
 */
public class Solution69 {
    /*
    实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
           long left=0;
           long right=x/2;
           while (left<right){
          long mid=left+(right-left)/2;
               if(mid*mid==x){
                   return (int)mid;
               }else if(mid*mid<x){
                   if((mid+1)*(mid+1)>x){
                       return (int)mid;
                   }else if((mid+1)*(mid+1)==x){
                       return (int) mid+1;
                   }
                   left=mid+1;
               }else {
                   if((mid-1)*(mid-1)<=x){
                       return (int)mid-1;
                   }
                   right=mid;
               }
           }
           return 0;
    }
    public int mySqrt2(int x) {
        if(x==0){
            return 0;
        }
        long left=1;
        long right=x/2;
        while (left<right){
            long mid=left+(right-left)/2;
                if(mid*mid>x){
                    right=mid-1;
                }else{
                    left=mid;
                }
        }
        return 0;
    }
}
