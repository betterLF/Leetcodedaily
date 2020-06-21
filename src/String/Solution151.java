package String;

/**
 * @authtor liFei
 * @date 2020/6/18-8:52
 */
public class Solution151 {
    /*
    给定一个字符串，逐个翻转字符串中的每个单词。
     */
    public String reverseWords(String s) {
        s=s.trim();//移去开头和末尾的空格
//          String []cur=s.split("\\s+");//正则匹配连续的空格为分隔符
        String []cur=s.split(" ");
          StringBuilder ans=new StringBuilder();
        for (int i = cur.length-1; i >=0 ; i--) {
            if(" ".equals(cur[i])){
                continue;
            }
            ans.append(cur[i].trim()).append(" ");
        }
        return ans.toString().trim();
    }
}
