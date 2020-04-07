import java.util.Arrays;

public class Solution977 {
    /*
    给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     */
    //解法1
    public int[] sortedSquares(int[] A) {
        int len=A.length;
        int res[]=new int[len];
        int temp[]=new int[len];
        int count=0;//temp数组下标
        int count2=0;//res数组下标
        for(int i=0;i<len;i++){
            int cur=A[i]*A[i];
           if(A[i]<0){//只要A[i]小于0，就加入temp数组
             temp[count++]=cur;
            }else if(A[i]>=0&&count!=0){//如果A[i]>=0.就拿它的平方值与负数最小的平方值相比，
               // 如果大于负数的平方值，temp就一直从末尾加入res中
               while(count-1>=0&&cur>=temp[count-1]){
                   res[count2++]=temp[count-1];
                   count--;
               }
               res[count2++]=cur;//最后加入该正数的平方
           }else{//说明没有负数了
               res[count2++]=cur;
           }
           if(count==len-count2){//如果全为负数(防止最大的正数小于负数)
               while(count-1>=0){
                   res[count2++]=temp[count-1];
                   count--;
               }
           }
        }
        return res;
    }
    //解法2,比较最前面和最后面的元素，大的加入结果集末尾
    public int[] sortedSquares2(int[] A) {
        int len=A.length;
        int res[]=new int[len];
        int count=len-1;
        for(int i=0,j=len-1;i<=j;){
            if(A[i]*A[i]>=A[j]*A[j]){
                res[count--]=A[i]*A[i];
                i++;
            }else{
                res[count--]=A[j]*A[j];
                j--;
            }
        }
        return res;
    }

}
