package Greedy;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/1-6:36
 */
public class Solution1338 {
    /*
给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     */
    public static void main(String[] args) {
        int a[]={7,7,7,7,7,7};
        minSetSize(a);
    }
    public static int minSetSize(int[] arr) {
           int index[]=new int[100001];
        for (int i = 0; i <arr.length ; i++) {
            index[arr[i]]++;
        }
        int j=0;
        for (int i=0;i<index.length;i++){
            if(index[i]!=0){
                index[j]=index[i];
                j++;
            }
        }
        Arrays.sort(index,0,j);
        int len=arr.length/2;
        int count=0;
        for (int i=j-1;i>=0;i--){
            len-=index[i];
            count++;
            if(len<=0){
                return count;
            }
        }
        return -1;
    }
}
