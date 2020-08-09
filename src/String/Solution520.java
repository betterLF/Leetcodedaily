package String;

/**
 * @authtor liFei
 * @date 2020/8/6-7:04
 */
public class Solution520 {
    /*
    给定一个单词，你需要判断单词的大写使用是否正确。
我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。
     */
    public boolean detectCapitalUse(String word) {
         char c=word.charAt(0);
         if(c>=97){//小写字符
             for (int i = 1; i <word.length() ; i++) {
                 if(word.charAt(i)<97){
                     return false;
                 }
             }
         }else {//大写字符
             if (word.length() >= 2) {
                 char cc = word.charAt(1);
                 if (cc > 97) {
                     for (int i = 2; i < word.length(); i++) {
                         if (word.charAt(i) < 97) {
                             return false;
                         }
                     }
                 } else {
                     for (int i = 0; i < word.length(); i++) {
                         if (word.charAt(i) >= 97) {
                             return false;
                         }
                     }
                 }
             }
         }
         return true;
    }
}
