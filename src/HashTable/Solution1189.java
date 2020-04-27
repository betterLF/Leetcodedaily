package HashTable;

/**
 * @authtor liFei
 * @date 2020/4/23-14:25
 */
public class Solution1189 {
    /*
    给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
     */
    public int maxNumberOfBalloons(String text) {
         int ans[]=new int[26];
         for(char cur:text.toCharArray()){
             ans[cur-'a']++;
         }
         int min=ans[0];
         min=min<ans[1]?min:ans[1];
        min=min<ans[11]/2?min:ans[11]/2;
        min=min<ans[13]?min:ans[13];
        min=min<ans[14]/2?min:ans[14]/2;
        return min;
    }
}
