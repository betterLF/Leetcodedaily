package String;

/**
 * @authtor liFei
 * @date 2020/7/14-8:06
 */
public class Solution395 {
    /*
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     */
    public static void main(String[] args) {
        longestSubstring("weitong",2);
    }
    public static int longestSubstring(String s, int k) {
        if(s.length()<k){
            return 0;
        }
           int []num=new int[26];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
          num[c[i]-'a']++;
        }
        int left=0;
        int right=s.length()-1;
        while (right-left+1>=k&&num[c[left]-'a']<k){
            left++;
        }
        while (right-left+1>=k&&num[c[right]-'a']<k){
               right--;
        }
        for (int i = left; i <=right; i++) {
            if (num[c[i]-'a']< k) {
                return Math.max(longestSubstring(s.substring(left, i), k), longestSubstring(s.substring(i+1,right+1), k));
            }
        }
             return right-left+1;
    }


}