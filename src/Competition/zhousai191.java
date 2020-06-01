package Competition;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/31-10:26
 */
public class zhousai191 {
    /*
给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
请你计算并返回该式的最大值。
     */

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2]);
    }

    /*
矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中 horizontalCuts[i]
是从矩形蛋糕顶部到第  i 个水平切口的距离，类似地， verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离。
请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。
由于答案可能是一个很大的数字，因此需要将结果对 10^9 + 7 取余后返回。
     */
    public static void main(String[] args) {
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long a = getMaxLength(horizontalCuts, h);
        long b = getMaxLength(verticalCuts, w);
        return (int) ((a * b) % ((long) (Math.pow(10, 9) + 7)));
    }

    private static long getMaxLength(int[] arr, int length) {
        if (arr.length == 1) {
            return Math.max(length - arr[0], arr[0]);
        }
        Arrays.sort(arr);
        int len = arr.length;
        long max = Math.max(arr[0], length - arr[len - 1]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }

    /*
n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一
一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
     */
    public int minReorder(int n, int[][] connections) {
        int[] access = new int[n];
        access[0] = 1;
        int count = 0;
        int a = 1;
        boolean flag = true;
        while (true) {
            for (int i = 0; i < connections.length; i++) {
                if (access[connections[i][1]] == 0 && access[connections[i][0]] == 1) {
                    access[connections[i][1]] = 1;
                    count++;
                    a++;
                }
                if (access[connections[i][1]] == 1 && access[connections[i][0]] == 0) {
                    access[connections[i][0]] = 1;
                    a++;
                }
                if (a == n) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                break;
            }
        }
return count;
    }
}