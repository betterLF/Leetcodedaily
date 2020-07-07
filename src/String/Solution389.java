package String;

/**
 * @authtor liFei
 * @date 2020/7/4-7:01
 */
public class Solution389 {
    /*
给定两个字符串 s 和 t，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
     */
    public char findTheDifference(String s, String t) {
        int []count=new int[26];
        for (char cur:s.toCharArray()){
            count[cur-'a']++;
        }
        for (char cur:t.toCharArray()){
            int temp=cur-'a';
            if(count[temp]==0){
                return cur;
            }else{
                count[temp]--;
            }
        }
        return ' ';
    }
    public char findTheDifference2(String s, String t) {
          char res=0;
          int len=s.length();
        for (int i = 0; i <len ; i++) {
            res^=(s.charAt(i)^t.charAt(i));
        }
        res^=t.charAt(len);
        return res;
    }
}
