package String;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/6/21-17:10
 */
public class Solution205 {
    /*
    给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();
        char []ss=s.toCharArray();
        char []tt=t.toCharArray();
        for (int i = 0; i <ss.length ; i++) {
         if(map1.containsKey(ss[i])){
             if(map1.get(ss[i])!=tt[i]){
                 return false;
             }
         }else{
             map1.put(ss[i],tt[i]);
         }
            if(map2.containsKey(tt[i])){
                if(map2.get(tt[i])!=ss[i]){
                    return false;
                }
            }else{
                map2.put(tt[i],ss[i]);
            }
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        int []c1=new int[257];
        int []c2=new int[257];
        char []ss=s.toCharArray();
        char []tt=t.toCharArray();
        for (int i = 0; i <ss.length ; i++) {
            if(c1[ss[i]]==0){
                c1[ss[i]]=tt[i];
            }else{
                if(c1[ss[i]]!=tt[i]){
                    return false;
                }
            }
            if(c2[tt[i]]==0){
                c2[tt[i]]=ss[i];
            }else{
                if(c2[tt[i]]!=ss[i]){
                    return false;
                }
            }
        }
        return true;
    }
}


