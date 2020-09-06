package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/9/3-7:32
 */
public class Solution747 {
    /*
    在一个给定的数组nums中，总是存在一个最大元素 。
查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
如果是，则返回最大元素的索引，否则返回-1。
     */
//    public int dominantIndex(int[] nums) {
//              if(nums.length==1){
//                  return 0;
//              }
//              int max=Math.max(nums[0],nums[1]);
//              int sec=Math.min(nums[0],nums[1]);
//              int ans=0;
//              if(max==nums[1]){
//                  ans=1;
//              }
//        for (int i = 2; i <nums.length ; i++) {
//            if(nums[i]>max){
//                sec=max;
//                max=nums[i];
//                ans=i;
//            }else if(nums[i]>sec){
//                sec=nums[i];
//            }
//        }
//        return max>=2*sec?ans:-1;
//    }
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != index && max < 2 * nums[i]) {
                return -1;
            }
        }
        return index;
    }
}
