package String;

/**
 * @authtor liFei
 * @date 2020/7/6-7:59
 */
public class Solution318 {
 /*
    给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
    并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
    */
 public int maxProduct(String[] words) {
       int []bitwise=new int[words.length];
     for (int i = 0; i <words.length ; i++) {//得到每个字母出现的字符
         int cur=0;
         for (char c:words[i].toCharArray()){
             cur|=(1<<(c-'a'));
         }
         bitwise[i]=cur;
     }
     int ans=0;
     for (int i = 0; i <words.length-1 ; i++) {
         int len=words[i].length();
         for (int j = i; j <words.length ; j++) {
             if((bitwise[i]&bitwise[j])==0){
               ans=Math.max(ans,len*words[j].length());
             }
         }
     }
     return ans;
 }
}
