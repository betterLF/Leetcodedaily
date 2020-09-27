package String;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/9/25-8:58
 */
public class Solution767 {
    /*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
若可行，输出任意可行的结果。若不可行，返回空字符串。
     */
    public String reorganizeString(String S) {
            int []count=new int[26];
            int len=S.length();
        for (int i = 0; i <S.length() ; i++) {
            count[S.charAt(i)-'a']+=100;
        }
        for (int i = 0; i <26 ; i++) {
            count[i]+=i;
        }
        Arrays.sort(count);
        if(count[25]>(len+1)/2){
            return "";
        }
        char []ans=new char[len];
        int t=0;
        for (int i = 25; i>=0 ; i++) {
            int cur=count[i]/100;
            char cc=(char) ('a'+count[i]%100);
            while (cur!=0){
                ans[t]=cc;
                t+=2;
                if(t>=len){
                    t=1;
                }
                cur--;
            }
        }
        return new String(ans);
    }
}
