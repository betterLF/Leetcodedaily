package String;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/6/1-7:19
 */
public class Solution125 {
    /*
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
     */
    //追求速度可以直接前面双指针比较，即左右只要出现字母或者数字就比较
    public boolean isPalindrome(String s) {
        ArrayList<Character> ans = new ArrayList<>();
        for (char cur : s.toCharArray()) {
            if (cur >= 'A' && cur <= 'Z') {
                ans.add((char) ('A' + 32));
            } else if (cur >= 'a' && cur <= 'z') {
                ans.add(cur);
            } else if (cur >= '0' && cur <= '9') {
                ans.add(cur);
            }
        }
        int i = 0;
        int j = ans.size() - 1;
        while (i < j) {
            if (ans.get(i) != ans.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            while (i < c.length && !(c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z' || c[i] >= '0' && c[i] <= '9')) {
                i++;
            }
            if (i >= c.length) {
                return true;
            }
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] += 32;
            }
            while (j >= 0 && !(c[j] >= 'a' && c[j] <= 'z' || c[j] >= 'A' && c[j] <= 'Z' || c[j] >= '0' && c[j] <= '9')) {
                j--;
            }
            if (j < 0) {
                return true;
            }
            if (c[j] >= 'A' && c[j] <= 'Z') {
                c[j] += 32;
            }
            if (i < j) {
                if (c[i] != c[j]) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
