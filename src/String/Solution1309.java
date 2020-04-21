package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/20-19:14
 */
public class Solution1309 {
    /*
    给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
字符（'a' - 'i'）分别用（'1' - '9'）表示。
字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
返回映射之后形成的新字符串。
题目数据保证映射始终唯一。
     */
    public static void main(String[] args) {
      freqAlphabets("10#11#12");
    }
    public static String freqAlphabets(String s) {
        List<Character> ans=new ArrayList<>();
        for (char cur:s.toCharArray()) {
            if(cur!='#'){
                ans.add((char) (cur+48));
            }else{
               char n=(char)(ans.remove(ans.size() - 1)-48);
                char m=(char)(ans.remove(ans.size() - 1)-48);
               int cc=Integer.parseInt(""+m+n);
               ans.add((char)(cc+96));
            }
        }
        StringBuilder res=new StringBuilder();
       for(Character cur:ans){
           res.append(cur);
       }
       return res.toString();
    }
    public static String freqAlphabets2(String s) {
       StringBuilder ans=new StringBuilder();
       char c[]=s.toCharArray();
        for (int i = 0; i <c.length ; ) {
            if(i+2<c.length&&c[i+2]=='#'){
                ans.append((char)(Integer.parseInt(""+c[i]+c[i+1])+96));
                i+=3;
            }else{
                ans.append((char)(c[i]+48));
                i++;
            }
        }
        return ans.toString();
    }
    public static String freqAlphabets3(String s) {
        StringBuilder ans=new StringBuilder();
        char a[]=new char[27];
        for(int i=1;i<a.length;i++){
            a[i]=(char)(i+96);
        }
        char c[]=s.toCharArray();
        for (int i = 0; i <c.length ; ) {
            if(i+2<c.length&&c[i+2]=='#'){
                ans.append(a[(c[i]-'0')*10+c[i+1]-'0']);
                i+=3;
            }else{
                ans.append(a[c[i]-'0']);
                i++;
            }
        }
        return ans.toString();
    }
}
