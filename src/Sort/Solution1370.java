package Sort;

/**
 * @authtor liFei
 * @date 2020/4/16-9:39
 */
public class Solution1370 {
    /*
给你一个字符串 s ，请你根据下面的算法重新构造字符串：
1从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
2从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
3重复步骤 2 ，直到你没法从 s 中选择字符。
4从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
5从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
6重复步骤 5 ，直到你没法从 s 中选择字符。
7重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
请你返回将 s 中字符重新排序后的 结果字符串 。
     */
    public String sortString(String s) {
      char c[]=s.toCharArray();
      int len=s.length();
      int res[]=new int[26];
       for(char cur:c){
           res[cur-'a']++;
       }
       StringBuilder ans=new StringBuilder();
       int count=0;
       while(count!=len){//重复步骤1-6
           //重复步骤1到3
           for (int i = 0; i <res.length ; i++) {
               if(res[i]!=0){
                   ans.append((char) (i+'a'));
                   res[i]--;
                   count++;
               }
           }
           for (int i = res.length-1; i>=0 ; i--) {
               if(res[i]!=0){
                   ans.append((char) (i+'a'));
                   res[i]--;
                   count++;
               }
           }
       }
       return ans.toString();
    }
}
