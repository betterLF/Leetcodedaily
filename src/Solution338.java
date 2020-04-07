public class Solution338 {
    /*
    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     */
    public int[] countBits(int num) {
        int n = 0;
        int count = 0;
        int res[] = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i < num + 1; i++) {
            if (i == (int) Math.pow(2, count)) {
                res[i] = 1;
                n = i;
                count++;
            } else {
                res[i] = res[n] + res[i - n];
            }
        }
        return res;
    }

    //找规律！偶数i：偶数*2在二进制数中其实是在末尾加0,1的个数不变
    //所以res[i]=res[i/2];
    //奇数i：i-1为偶数，因为两者就差了个1，而i-1的末尾不可能为1，否则i-1就是奇数，
    // 所以两者差1，就是在i-1的基础上末尾变为1
    //所以res[i]=res[i-1]+1;
    public int[] countBits2(int num) {
        int res[] = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
            return res;
    }
}