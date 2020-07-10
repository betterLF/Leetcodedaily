package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/7-8:17
 */
public class Solution324 {
    /*
    给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     */
    public void wiggleSort(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len=nums.length,i = 0;
        //复制
        int []smaller=Arrays.copyOfRange(nums,0,(len%2==0?len/2:len/2+1));
        int []bigger=Arrays.copyOfRange(nums,smaller.length,nums.length);
        //穿插
        for (; i < len / 2; i++) {//翻转插入
            nums[2*i]=smaller[smaller.length-1-i];
            nums[2*i+1]=bigger[len/2-1-i];
        }
        if (len%2!=0) nums[2*i]=smaller[smaller.length-1-i];//如果是奇数个数，原排序的中间数在开头
    }
}
