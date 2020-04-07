public class Solution905
    /*
    给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
你可以返回满足此条件的任何数组作为答案。
     */
{
    public int[] sortArrayByParity(int[] A) {
         int count=0;//判断偶数个数,也即返回数组的奇数初始下标
        for(int num:A){
            if(num%2==0){
                count++;
            }
        }
        int res[]=new int[A.length];
        int count2=0;//偶数初始下标
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                res[count2++]=A[i];
            }else{
                res[count++]=A[i];
            }
        }
        return res;
    }
}
