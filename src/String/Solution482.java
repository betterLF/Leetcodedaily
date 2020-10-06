package String;

/**
 * @authtor liFei
 * @date 2020/7/21-6:42
 */
public class Solution482 {
    /*
    有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
给你一个数字 K，请你重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符；而第一个分组中，
至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder ans = new StringBuilder();
        char[] c = S.toCharArray();
        int count = 0;
        StringBuilder cur = new StringBuilder();
        for (int j = c.length-1; j>=0; j--) {
            if (c[j] != '-') {
                count++;
                if (c[j] >= 97) {//小写转大写
                    cur.append((char) (c[j] - 32));
                } else {
                    cur.append(c[j]);
                }
                if (count == K) {
                    ans.append("-").append(cur.toString());
                    cur = new StringBuilder();
                    count=0;
                }
            }
        }
        if(count!=0){
            ans.append("-").append(cur.toString());
        }
        if(ans.length()!=0) {
            return ans.reverse().deleteCharAt(ans.length() - 1).toString();
        }else{
            return new String();
        }
    }
}
