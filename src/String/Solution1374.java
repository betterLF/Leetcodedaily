package String;

/**
 * @authtor liFei
 * @date 2020/4/21-7:34
 */
public class Solution1374 {
    /*
给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
     */
    public String generateTheString(int n) {
        if(n==1){
            return "a";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 2; i++) {
            ans.append('a');
        }
        if (n % 2 == 0) {
            ans.append("ac");
        } else {
            ans.append("bc");
        }
        return ans.toString();
    }
}
