package Greedy;

/**
 * @authtor liFei
 * @date 2020/9/26-7:30
 */
public class Solution775 {
    /*
    数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，
    局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
     */
    public boolean isIdealPermutation(int[] A) {
        if(A.length<=2){
            return true;
        }
        int len=A.length;
        int min[]=new int[len];
        min[len-1]=A[len-1];
        min[len-2]=Math.min(min[len-1],A[len-2]);
        for (int i = len-3;i>=0; i--) {
          min[i]=Math.min(A[i],min[i+1]);
          if(A[i]>min[i+2]){
              return false;
          }
        }
        return true;
    }
}
