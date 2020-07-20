package String;

/**
 * @authtor liFei
 * @date 2020/7/17-7:21
 */
public class Solution409 {
    /*
    给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     */
    public int longestPalindrome(String s) {
        int len = s.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char cur : s.toCharArray()) {
            if (cur <= 'Z') {
                c1[cur - 'A']++;
            } else {
                c2[cur - 'a']++;
            }
        }
        int sum = 0;//偶数总和
        boolean flag=true;
        for (int i = 0; i < 26; i++) {
            System.out.println(c1[i]+","+c2[i]);
            if (c1[i] % 2 == 0) {
                sum += c1[i];
            } else {
               sum+=c1[i]-1;
               flag=false;
            }
            if (c2[i] % 2 == 0) {
                sum += c2[i];
            } else {
                     sum+=c2[i]-1;
                     flag=false;
            }
        }
        return flag?sum:sum+1;
    }
}
