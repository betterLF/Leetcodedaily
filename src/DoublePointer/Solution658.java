package DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/14-12:23
 */
public class Solution658 {
    /*
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
     */
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int index=binarySearchForIndex(arr,x);
//        System.out.println(index);
//        if(index<=0){
//            return getAns(0,k,arr);
//        }else if(index>=arr.length-1){
//            return getAns(arr.length-k,k,arr);
//        }
//        List<Integer> ans=new ArrayList<>();
//        int left=Math.max(index-1-k,0);
//        int right=Math.min(index+1+k,arr.length-1);
//        System.out.println(left+","+right);
//        while (right-left!=k-1){
//             if(x-arr[left]>arr[right]-x){
//                 left++;
//             }else{
//                 right--;
//             }
//        }
//        return getAns(left,k,arr);
//    }
//    private int binarySearchForIndex(int []arr,int x){
//        int left=0;
//        int right=arr.length-1;
//        while (left<right){
//            int mid=left+(right-left)/2;
//            if(arr[mid]<x){
//                left=mid+1;
//            }else{
//                right=mid;
//            }
//        }
//        return left;
//    }
//    private List<Integer> getAns(int form,int len,int []arr){
//        ArrayList<Integer> ans=new ArrayList<>();
//        for (int i = form; i <form+len ; i++) {
//            ans.add(arr[i]);
//        }
//        return ans;
//    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        while (end - start + 1 > k) {
            if (x - arr[start] > arr[end] - x) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = start; i <= end; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
