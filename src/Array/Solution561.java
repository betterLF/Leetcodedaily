import java.util.Arrays;

public class Solution561 {
    /*
    给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
    使得从1 到 n 的 min(ai, bi) 总和最大。
     */
    //元素总和=min*2+每一对差值之和，所以差值之和最小，min最大，所以要排序好的顺序进行分组
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            count += nums[i];
        }
        return count;
    }
//进行元素个数的计数，再进行排列，减少时间消耗
    public int arrayPaisSum2(int[] nums) {
        int arr[] = new int[200001];//因为数组中元素在-10000到10000之间
        for (int num : nums) {
            arr[num + 10000]++;//统计该字出现的次数
        }
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < 20001; i++) {
            if (arr[i] != 0 && flag == true) {
                sum += (i - 10000) * (arr[i] / 2);
                if (arr[i] % 2 == 1) {
                    sum += i - 10000;
                    flag = false;
                }
            } else if (arr[i] != 0 && flag == false) {
                arr[i] = arr[i] - 1;
                sum += (i - 10000) * (arr[i] / 2);
                if (arr[i] % 2 == 1) {
                    sum += i - 10000;
                    flag = false;
                } else {
                    flag = true;
                }
            }
        }
        return sum;
    }
}