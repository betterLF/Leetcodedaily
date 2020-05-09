package Array;

/**
 * @authtor liFei
 * @date 2020/5/7-7:51
 */
public class Solution1287 {
    /*
    给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
请你找到并返回这个整数
     */
    public int findSpecialInteger(int[] arr) {
       int len=arr.length/4;
       int temp=arr[0];
        int count=1;
        for (int i = 1; i <arr.length; i++) {
            if(temp==arr[i]){
                count++;
            }else{
                if(count>len){
                    return temp;
                }else{
                    temp=arr[i];
                    count=1;
                }
            }
        }
        return temp;
    }
    public int findSpecialInteger2(int[] arr) {
        int len=arr.length/4;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]==arr[i+len]){
             return arr[i];
            }
        }
        return -1;
    }
}
