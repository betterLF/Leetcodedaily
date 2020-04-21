package String;

/**
 * @authtor liFei
 * @date 2020/4/21-12:50
 */
public class Solution557 {
    /*
    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     */
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder ans=new StringBuilder();
        for (String cur:s1){
            ans.append(new StringBuilder(cur).reverse().toString()).append(" ");
        }
       return ans.deleteCharAt(ans.length()-1).toString();
    }
}
