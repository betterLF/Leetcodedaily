package Sort;

/**
 * @authtor liFei
 * @date 2020/4/16-10:17
 */
public class Solution922 {
    /*
    给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。
     */
    public int[] sortArrayByParityII(int[] A) {
        int len=A.length;
      int ji[]=new int[len/2];
      int ou[]=new int[len/2];
      int count1=0;
      int count2=0;
      for(int cur:A){
          if(cur%2==0){
              ou[count2++]=cur;
          }else{
              ji[count1++]=cur;
          }
      }
      for(int i=0;i<len;i++){
          A[i]=i%2==0?ou[i/2]:ji[i/2];
      }
      return A;
    }
    public int[] sortArrayByParityII2(int[] A) {
        int len=A.length;
        int ans[]=new int[len];
        int t=0;
        for (int x:A) {
           if(x%2==0){
               ans[t]=x;
               t+=2;
           }
        }
        t=1;
        for (int x:A) {
            if(x%2==1){
                ans[t]=x;
                t+=2;
            }
        }
        return ans;
    }
    public int[] sortArrayByParityII3(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {//保证i为偶数下标，j为奇数下标，如果偶数下标为奇数就去找奇数下标为偶数的数交换位置
                while (A[j] % 2 == 1)
                    j += 2;
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        return A;
    }
}
