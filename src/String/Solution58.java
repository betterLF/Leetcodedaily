package String;

/**
 * @authtor liFei
 * @date 2020/5/25-13:39
 */
public class Solution58 {
    /*
    给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     */
    public int lengthOfLastWord(String s) {
               String[] ans=s.split(" ");
               if(ans.length==0){
                   return 0;
               }
               return ans[ans.length-1].length();
    }
    //从尾向前遍历
    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

}
