package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @authtor liFei
 * @date 2020/5/18-7:26
 */
public class Solution1331 {
    /*

给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
序号代表了一个元素有多大。序号编号的规则如下：
序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。
     */
    public int[] arrayRankTransform(int[] arr) {

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int[] cur = {arr2[i], i};
            temp.add(cur);
        }
        Collections.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 1;
        arr2[temp.get(0)[1]] = 1;
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i)[0] == temp.get(i - 1)[0]) {
                arr2[temp.get(i)[1]] = count;
            } else {
                count++;
                arr2[temp.get(i)[1]] = count;
            }
        }
        return arr2;
    }
    public int[] arrayRankTransform2(int[] arr) {
        if (arr.length < 1) {
            return arr;
        }

        int arrMin = arr[0];
        int arrMax = arr[0];

        for (int num : arr) {
            if (num < arrMin) {
                arrMin = num;
            }
            if (num > arrMax) {
                arrMax = num;
            }
        }

        int[] nums = new int[arrMax - arrMin + 1];
        for (int num : arr) {
            nums[num - arrMin] = 1;//标记该值存在
        }

        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//标记该值所属的大小
                nums[i] = j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            arr[i] = nums[k - arrMin];//k-arrMin就是arr[i]在nums中对应的位置
        }

        return arr;
    }
}
