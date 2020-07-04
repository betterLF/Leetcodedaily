package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/7/2-7:13
 */
public class Solution367 {
    /*
    给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
说明：不要使用任何内置的库函数，如  sqrt。
     */
    public static void main(String[] args) {
         isPerfectSquare(361201);
    }
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4 || num == 9) {
            return true;
        }
        int left = 0;
        int right = num / 3;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long temp = (long)mid *(long) mid;
            if (temp == num) {
                return true;
            } else if (temp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left * left == num;
    }
}
