package String;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/6/25-7:21
 */
public class Solution290 {
    /*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public static void main(String[] args) {

    }
    public boolean wordPattern(String pattern, String str) {
      String[] s=new String[27];
        HashSet<String> set=new HashSet<>();
        String[] spilt=str.split(" ");
        if(spilt.length!=pattern.length()){
            return false;
        }
        int count=0;
         for (char cur:pattern.toCharArray()){
             if(s[cur-'a']!=null){//如果对应关系已经存在
                 if(!s[cur-'a'].equals(spilt[count])){
                     return false;
                 }
             }else{//如果对应关系不存在
                 if(set.contains(spilt[count])){//说明已经有元素与其对应
                     return false;
                 }else{
                     s[cur-'a']=spilt[count];
                     set.add(spilt[count]);
                 }
             }
             count++;
         }
         return true;
    }
}
