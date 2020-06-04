package Array;

/**
 * @authtor liFei
 * @date 2020/6/2-7:34
 */
public class Solution189 {
    /*
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public static void main(String[] args) {
        int []n= {-1,100,3,9};
        rotate2(n,2);
    }
    public static void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    public static void rotate2(int[] nums, int k) {
        int len=nums.length;
        int count=len;
        int temp=nums[0];
        int index=0;
        if(k==count){
            return;
        }
        int start=0;
        while (count!=0){
            int curIndex=(index+k)%len;
            int curTemp=nums[curIndex];
            nums[curIndex]=temp;
            index=curIndex;
            temp=curTemp;
            count--;
            if(index==start&&start+1<len) {
                start++;
                index=start;
                temp=nums[index];
            }
        }
    }
}
