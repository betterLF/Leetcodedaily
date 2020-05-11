package Greedy;

/**
 * @authtor liFei
 * @date 2020/5/10-7:38
 */
public class Solution991 {
    /*
    在显示着数字的坏计算器上，我们可以执行以下两种操作：
双倍（Double）：将显示屏上的数字乘 2；
递减（Decrement）：将显示屏上的数字减 1 。
最初，计算器显示数字 X。
返回显示数字 Y 所需的最小操作数。
     */
    public static int brokenCalc(int X, int Y) {
            int ans = 0;
            while (Y > X) {
                ans++;
                if (Y % 2 == 1)
                    Y++;
                else
                    Y /= 2;
            }

            return ans + X - Y;
        }

    }
