package String;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/20-6:38
 */
public class Solution1371 {
    /*
给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {//如果字符为a,5位二进制数的末位变化，如果变为0，代表出现偶数次，为1代表出现奇数次，后面同理
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {//如果此时大于0，说明出现过该状态，最大值就为当前最大值和当前状态-第一个该状态的长度。
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {//如果此时小于0，代表前面还未出现于当前status相等的状况，所以将当前的status值赋值为i+1
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
