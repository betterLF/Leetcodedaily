package BinarySearch;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/6/14-11:06
 */
public class Solution1300 {
    /*
    给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
    使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
请注意，答案不一定是 arr 中的数字。
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];//下标i代表前i个元素和
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[n - 1], ans = -1;//二分
        while (l <= r) {
            int mid = (l + r) / 2;
            int index = Arrays.binarySearch(arr, mid);//找到与中间值最接近的下标
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * mid;//计算以该中间值为value时的值大小
            if (cur <= target) {
                ans = mid;//该点是当前最接近(小于)target的值
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        int chooseSmall = check(arr, ans);//该值小于等于target
        int chooseBig = check(arr, ans + 1);//该值大于等于target
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans : ans + 1;//比较两个值大小
    }

    public int check(int[] arr, int x) {//计算value为x时的数组和
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }
    public int findBestValue2(int[] arr, int target) {
        int left = 1;
        int right = 100000;
        int max=0;
        for (int i = 0; i <arr.length ; i++) {
            max=Math.max(arr[i],max);
        }
        while(left<right){
            int mid =(right+left)/2;//找到中间值进行比较
            int res = sum(arr, mid);
            if(res < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        int x = sum(arr, left);
        int y = sum(arr, left-1);
        if(Math.abs(target-x)>=Math.abs(target-y)){
            return left-1>max?max:left-1;
        }else{
            return left>max?max:left;
        }
    }
    public int sum(int[] arr, int mid){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += Math.min(arr[i], mid);
        }
        return sum;
    }
}
