package Recursion;

/**
 * @authtor liFei
 * @date 2020/6/26-6:35
 */
public class Solution201 {
    /*
    给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
     */
    public int rangeBitwiseAnd(int m, int n) {
         int ans=0;
         if(m==n){
             return m;
         }
         while (m!=0){
            long temp=Num(m,n);
             if(temp<m){//说明temp在m之前
                 ans+=temp;
                 m-=temp;
                 n-=temp;
             }else{//说明temp在m，n之间
                 if(temp==m){
                     ans+=temp;
                 }
                  break;
             }
         }
         return ans;
    }
    //找到最接近m和n的2的倍数，如果m和n中包含该数，就返回该数，否则返回在m之前的那个数
    private long Num(int m,int n){
          long temp=1;
          while (temp<m){
              temp*=2;
          }
          if(temp==m){//如果m和temp相等，说明m是2的次方
              if(temp*2<=n){
                  return temp*2;
              }else{
                  return temp;
              }
          }
          if(temp<=n){
              return temp;
          }else{
              return temp/2;
          }
    }
}
