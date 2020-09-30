package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/27-10:39
 */
public class Solution784 {
    /*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，
我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     */
    List<String> ans;
    public List<String> letterCasePermutation(String S) {
         ans=new ArrayList<>();
         back(S.toCharArray(),0);
         return ans;
    }
    private void back(char []c,int start){
        if(start==c.length){
            ans.add(new String(c));
            return;
        }
        for (int i = start; i <c.length ; i++) {
             if('0'<=c[i]&&c[i]<='9'){
                 continue;
             }else{
                 back(c,i+1);
                 if(c[i]>='a'){
                     c[i]-=32;
                     back(c,i+1);
                     return;
                 }else {
                     c[i]+=32;
                     back(c,i+1);
                     return;
                 }
             }
        }
        if('0'<=c[c.length-1]&&c[c.length]<='9'){
            back(c,c.length);
        }
    }
}
