public class Solution1304 {
    /*
    给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     */
    public int[] sumZero(int n) {
        int res[] = new int[n];
        int i = 0;
        int j = n % 2 == 0 ? n - 1 : n - 2;
        int temp = n;
        while (i < j) {
            res[i++] = temp;
            res[j--] = -temp;
            temp -= 2;
        }
        if (n % 2 == 1) {
            res[n - 1] = 0;
        }
        return res;
    }
}