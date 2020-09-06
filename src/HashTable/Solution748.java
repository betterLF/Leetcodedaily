package HashTable;

/**
 * @authtor liFei
 * @date 2020/9/3-7:44
 */
public class Solution748 {
    /*
    如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。
    在所有完整词中，最短的单词我们称之为最短完整词。
单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int []hash=new int[26];
        for (int i = 0; i <licensePlate.length() ; i++) {
             int cur=licensePlate.charAt(i);
             if(cur>=65&&cur<=90){
                 hash[cur-65]++;
             }else if(cur>=97&&cur<=122){
                 hash[cur-97]++;
             }
        }
        String ans=null;
        for (String cur:words){
            if(contains(hash,cur)){
                if(ans==null){
                    ans=cur;
                }else if(ans.length()>cur.length()){
                    ans=cur;
                }
            }
        }
        return ans;
    }
    private boolean contains(int[] hashArr, String word) {
        int[] hash = hash(word);
        for(int i = 0; i < 26; i++) {
            if(hashArr[i] > hash[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] hash(String word) {
        int[] hashArr = new int[26];
        for(char ch : word.toCharArray()) {
                hashArr[ch - 'a']++;
        }
        return hashArr;
    }
}
