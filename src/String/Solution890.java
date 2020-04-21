package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/21-13:05
 */
public class Solution890 {
    /*
    你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
返回 words 中与给定模式匹配的单词列表。
你可以按任何顺序返回答案。
     */
    public static void main(String[] args) {
      String  words[] = {"abc","deq","mee","aqq","dkd","ccc"}, pattern = "abb";
      findAndReplacePattern(words,pattern);
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
          String start=toString(pattern);
          for(String cur:words){
              if(start.equals(toString(cur))){
                  res.add(cur);
              }
          }
          return res;
    }
    private static String toString(String cur){
        HashMap<Character,Character> temp=new HashMap<>();
        StringBuilder ans=new StringBuilder();
        int name=97;
        for(char c:cur.toCharArray()){
            if(temp.containsKey(c)){
                ans.append(temp.get(c));
            }else{
                temp.put(c,(char)(name++));
                ans.append(temp.get(c));
            }
        }
        return ans.toString();
    }
}
