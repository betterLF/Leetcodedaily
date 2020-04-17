package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/4/17-8:33
 */
public class Solution242 {
    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length()){
          return false;
      }
      char ss[]=s.toCharArray();
      char tt[]=t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i <ss.length ; i++) {
            if(ss[i]!=tt[i]){
                return false;
            }
        }
        return true;
    }
}
