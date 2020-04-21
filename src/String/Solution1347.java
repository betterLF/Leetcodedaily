package String;

/**
 * @authtor liFei
 * @date 2020/4/21-17:00
 */
public class Solution1347 {
    /*
    给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
返回使 t 成为 s 的字母异位词的最小步骤数。
字母异位词 指字母相同，但排列不同的字符串。
     */
    public int minSteps(String s, String t) {
             char ss[]=s.toCharArray();
             char tt[]=t.toCharArray();
             int numT[]=new int[26];
             for (char cur:tt){
                 numT[cur-'a']++;
             }
             for (char cur:ss){
                 if(numT[cur-'a']!=0){
                     numT[cur-'a']--;
                 }
             }
             int sum=0;
             for (int num:numT){
                 sum+=num;
             }
             return sum;
    }
    public int minSteps2(String s, String t) {
        char ss[]=s.toCharArray();
        char tt[]=t.toCharArray();
        int numT[]=new int[26];
        int numS[]=new int[26];
          for (int i=0;i<s.length();i++){
              numS[ss[i]-'a']++;
              numT[tt[i]-'a']++;
          }
          int ans=0;
          for (int i=0;i<26;i++){
              ans+=Math.abs(numS[i]-numT[i]);
          }
        return ans/2;
    }
}
