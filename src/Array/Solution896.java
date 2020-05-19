package Array;

/**
 * @authtor liFei
 * @date 2020/5/18-7:51
 */
public class Solution896 {
    /*
如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。
     */
    public boolean isMonotonic(int[] A) {
           if(A.length==1){
               return true;
           }
           int count=0;
           for (int i=1;i<A.length;i++){
               int temp=A[i]-A[i-1];
               if(temp==0){
                   continue;
               }
               if(count!=0) {
                   if (count == 1) {
                       if (temp < 0) {
                           return false;
                       }
                   } else {
                       if (temp > 0) {
                           return false;
                       }
                   }
               }else{
                      count=temp>0?1:-1;
                   }
               }
           return true;
           }
    }

