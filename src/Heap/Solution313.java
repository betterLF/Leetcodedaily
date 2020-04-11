package Heap;

/**
 * @authtor liFei
 * @date 2020/4/11-7:54
 */
public class Solution313 {
    /*
    编写一段程序来查找第 n 个超级丑数。
超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
     */
    public static void main(String[] args) {
        int arr[]={2,7,13,19};
        nthSuperUglyNumber(12,arr);
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
           int len=primes.length;
           int index[]=new int[len];
           long res[]=new long[n];
           res[0]=1;
           for(int i=1;i<n;i++){
               long min=res[index[0]]*primes[0];
               for (int j = 1; j <len ; j++) {//循环求出当前的最小值
                   min=Math.min(min,res[index[j]]*primes[j]);
               }
               for (int k = 0; k <len ; k++) {//取得最小值的元素后移
                   if(min==res[index[k]]*primes[k]){
                       index[k]++;
                   }
               }
               res[i]=min;
           }
           return (int)res[n-1];
    }
}
