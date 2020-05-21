package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/20-7:44
 */
public class Solution1408 {
    /*
    给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
     */
    public List<String> stringMatching(String[] words) {
           int []index=new int[words.length];
           StringBuilder s=new StringBuilder();
           for (String cur:words){
               s.append(cur).append(",");
           }
        List<String> ans=new ArrayList<>();
        String cur=s.toString();
        for (int i = 0; i <words.length ; i++) {
               if(cur.indexOf(words[i])!=cur.lastIndexOf(words[i])){
                              ans.add(words[i]);
            }
        }
        return ans;
    }
}
