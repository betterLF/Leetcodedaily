package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/5/2-6:35
 */
public class Solution852 {
    /*
    我们把符合下列属性的数组 A 称作山脉：
A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     */
    public int peakIndexInMountainArray(int[] A) {
           return binarySearch(A,0,A.length);
    }
    private int binarySearch(int []A,int start,int end){
        int mid=(start+end)/2;
        if (A[mid]>A[mid-1]&&A[mid]>A[mid+1]){
            return mid;
        }else if(A[mid]<A[mid+1]){
            return binarySearch(A,mid,end);
        }else{
            return binarySearch(A,start,mid);
        }
    }
}
