package String;

/**
 * @authtor liFei
 * @date 2020/5/20-7:24
 */
public class Solution824 {
    /*
    给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
山羊拉丁文的规则如下：
如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
例如，单词"apple"变为"applema"。
如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
例如，单词"goat"变为"oatgma"。
根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
返回将 S 转换为山羊拉丁文后的句子。
     */
    public String toGoatLatin(String S) {
          StringBuilder ans=new StringBuilder();
          StringBuilder temp=new StringBuilder();
          String []s=S.split(" ");
        for (int i = 0; i <s.length ; i++) {
            ans.append(toString(s[i])).append(temp.append('a').toString()).append(" ");
        }
        return ans.deleteCharAt(ans.length()-1).toString();
    }
    private String toString(String s){
        if(s.charAt(0)=='a'||s.charAt(0)=='e'||s.charAt(0)=='i'||s.charAt(0)=='o'||s.charAt(0)=='u'||
                s.charAt(0)=='A'||s.charAt(0)=='E'||s.charAt(0)=='I'||s.charAt(0)=='O'||s.charAt(0)=='U'){
            return new StringBuilder().append(s).append("ma").toString();
        }else{
            return new StringBuilder().append(s.substring(1)).append(s.charAt(0)).append("ma").toString();
        }
    }
}
