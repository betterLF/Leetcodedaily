package String;

/**
 * @authtor liFei
 * @date 2020/5/21-6:35
 */
public class Solution5 {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] max = new int[1];
        int[] index = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (i + 1 < c.length && c[i] == c[i + 1]) {
                int j = i - 1, k = i + 2;
                isMax(c, i - 1, i + 2, index, max);
            }
            isMax(c, i - 1, i + 1, index, max);
        }
        return s.substring(index[0], index[1] + 1);
    }

    private void isMax(char[] c, int j, int k, int[] index, int[] max) {
        while (j >= 0 && k < c.length) {
            if (c[j] == c[k]) {
                j--;
                k++;
            } else {
                break;
            }
        }
        if (k - j - 1 > max[0]) {
            max[0] = k - j - 1;
            index[0] = j + 1;
            index[1] = k - 1;
        }
    }

    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];//dp[i][j]表示第i个元素到第j个元素是否回文
        int[] index = new int[2];//存放回文子串前后索引
        int max = 0;//存放最大长度
        char[] c = s.toCharArray();
        for (int l = 0; l < len; l++) {//dp数组行与列的差值
            for (int i = 0; i < len-1; i++) {//每一行，代表从第几个元素开始
                int j = i + l;
                if (l == 0) {//如果差值为0，代表当前元素，本身就为回文子串
                    dp[i][j] = true;
                } else if (l == 1) {//如果差值为1，代表相邻两个子串
                    dp[i][j] = (c[i] == c[j]);
                } else if (j < len) {
                    dp[i][j] = (dp[i + 1][j - 1]) && (c[i] == c[j]);
                }
                if (j<len&&dp[i][j] == true && j - i + 1 > max) {
                    index[0] = i;
                    index[1] = j;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(index[0], index[1] + 1);
    }
}
