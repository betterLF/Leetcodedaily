package Array;

/**
 * @authtor liFei
 * @date 2020/7/17-8:33
 */
public class Solution414 {
    /*
    给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     */
    public static void main(String[] args) {
    }
    public int thirdMax(int[] nums) {
        long max=(long) Integer.MAX_VALUE+1;
      long first= getNowMax(nums, max);
      long second=getNowMax(nums,first);
        if(second==(long)-2147483648-1){
            return (int)first;
        }
       long third=getNowMax(nums,second);
        if(third==(long)-2147483648-1){
            return (int)first;
        }
        return (int)third;
    }
    private long getNowMax(int []nums,long curMax){
        long ans=(long)-2147483648-1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>=curMax){
                continue;
            }
            ans=Math.max(ans,nums[i]);
        }
        return ans;
    }
    public int thirdMax2(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = num;
            } else if (num > max3 && num != max2 && num != max1) {
                max3 = num;
            }
        }
        if (max3 != Long.MIN_VALUE) {
            return (int) max3;
        } else {
            return (int) max1;
        }
    }
}
