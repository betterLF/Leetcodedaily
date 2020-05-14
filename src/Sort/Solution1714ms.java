package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/12-10:20
 */
public class Solution1714ms {
    /*
    设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     */
    public static void main(String[] args) {
        int a[]={3,2,41,42,13,41,34,12,432,13,2,35};
        smallestK(a,4);
    }
    public static int[] smallestK(int[] arr, int k) {//挖坑法
        if(k==0||arr.length==0){
            return new int[0];
        }
        int left=0;
        int right=arr.length-1;
        int count=0;
       while(true){
           int pivot=arr[left];
           int i=left;
           int j=right;
          while (i<j){
              while (i<j&&arr[j]>=pivot){
                  j--;
              }
              arr[i]=arr[j];
              while (i<j&&arr[i]<=pivot){
                  i++;
              }
              arr[j]=arr[i];
          }
          arr[i]=pivot;
           count=i;
           if(count>k){
               right=count-1;
           }else if(count<k-1){
               left=count+1;
           }else{
               break;
           }
       }
       return Arrays.copyOf(arr,k);
    }
    public static int[] smallestK2(int[] arr, int k) {//交换法
        if(k==0||arr.length==0){
            return new int[0];
        }
        int left=0;
        int right=arr.length-1;
        int count=0;
        while(true){
            int pivot=arr[left];
            int i=left;
            int j=right+1;
            while (i<j){
                while (arr[++i]<pivot){
                    if(i==right){
                        break;
                    }
                }
                while (arr[--j]>pivot){
                    if(left==j){
                        break;
                    }
                }
                if(i<j){
                    swap(arr,i,j);
                }
            }
            swap(arr,j,left);
            count=j;
            if(count>k){
                right=count-1;
            }else if(count<k-1){
                left=count+1;
            }else{
                break;
            }
        }
        return Arrays.copyOf(arr,k);
    }
    private  static void swap(int []arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
