package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @authtor liFei
 * @date 2020/4/22-18:27
 */
public class Solution791 {
    /*
    字符串S和T只包含小写字符。在S中，所有字符只会出现一次。
S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，
如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
返回任意一种符合条件的字符串T。
     */
    public String customSortString(String S, String T) {
        int index[]=new int[26] ;
        int count=-1;
        char s[]=S.toCharArray();
        for (int i=0;i<s.length;i++){
            index[s[i]-'a']=count;
            count--;
        }
        Comparator<Character> c=new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return index[o2-'a']-index[o1-'a'];
            }
        };
        int len=T.length();
        Character tt[]=new Character[len];
        for (int i=0;i<len;i++){
            tt[i]=T.charAt(i);
        }
        Arrays.sort(tt,c);
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i <len; i++) {
            ans.append(tt[i]);
        }
        return ans.toString();
    }
    public String customSortString2(String S, String T) {
        int index[]=new int[26] ;
        for (char cur:T.toCharArray()){
            index[cur-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i <S.length(); i++) {
            int cur=S.charAt(i)-'a';
            while (index[cur]!=0){
                ans.append((char) (cur+'a'));
                index[cur]--;
            }
        }
          for (int i=0;i<index.length;i++){
              while (index[i]!=0){
                  ans.append((char)(i+'a'));
                  index[i]--;
              }
          }
        return ans.toString();
    }
}
