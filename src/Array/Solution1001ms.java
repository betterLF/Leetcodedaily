package Array;

/**
 * @authtor liFei
 * @date 2020/5/14-7:08
 */
public class Solution1001ms {
    /*
    给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。
     */
    public void merge(int[] A, int m, int[] B, int n) {
         int []cur_A=new int[m];
        for (int i = 0; i <m ; i++) {
            cur_A[i]=A[i];
        }
        merge(A,cur_A,B);
    }
    private void merge(int[]A,int []cur_A,int []B){
        int len1=cur_A.length;
        int len2=B.length;
        int count1=0;
        int count2=0;
        int i=0;
        while (count1<len1&&count2<len2){
            if(cur_A[count1]<=B[count2]){
                A[i]=cur_A[count1];
                count1++;
            }else{
                A[i]=B[count2];
                count2++;
            }
            i++;
        }
        if(count1==len1){
            while (count2!=len2){
                A[i]=B[count2];
                count2++;
                i++;
            }
        }else{
            while (count1!=len1){
                A[i]=cur_A[count1];
                count1++;
                i++;
            }
        }
    }
}
