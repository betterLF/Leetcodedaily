package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/4/11-8:43
 */
public class Solution40ms {
    /*
    输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public static void main(String[] args) {
        int arr[]={3,2,1};
        getLeastNumbers4(arr,2);
    }
    public int[] getLeastNumbers(int[] arr, int k) {//慢！
        int len=arr.length;
        PriorityQueue<Integer> res=new PriorityQueue<>();
        for (int i = 0; i <len ; i++) {
            res.add(arr[i]);
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=res.poll();
        }
        return ans;
    }
    public int[] getLeastNumbers2(int[] arr, int k) {//比1快
        Arrays.sort(arr);
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=arr[i];
        }
        return ans;
    }
    public int[] getLeastNumbers3(int[] arr, int k) {//慢！
        int len=arr.length;
        PriorityQueue<Integer> res=new PriorityQueue<>();
        for (int i = 0; i <k; i++) {
            res.add(-arr[i]);
        }
        for(int i=k;i<len;i++){
             if(res.peek()<-arr[i]){
                 res.poll();
                 res.add(-arr[i]);
             }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=-res.poll();
        }
        return ans;
    }
    public static int[] getLeastNumbers4(int[] arr, int k) {//数字范围有限制，直接计数排序,最快
       int ans[]=new int[100001];
       for(int cur:arr){
           ans[cur]++;
       }
       int res[]=new int[k];
       int count=0;
       for(int i=0;i<ans.length&&count!=k;){
           if(ans[i]==0){
               i++;
               continue;
           }else{
              res[count++]=i;
              ans[i]--;
           }
       }
        return res;
    }
}
