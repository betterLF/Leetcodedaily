package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/15-7:03
 */
public class Solution131 {
    /*
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
     */
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        List<String> cur=new LinkedList<>();
        back(s,0,cur);
        return ans;
    }
    private void back(String s,int start,List<String> cur){
        if(start==s.length()){
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = start+1; i <=s.length() ; i++) {
            String temp=s.substring(start,i);
            if(isHuiWen(temp)){
                cur.add(temp);
                back(s,i,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isHuiWen(String s){
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    //转成字符数组进行回文的判断，少了很多次减串操作，便捷
    public List<List<String>> partition2(String s) {
        ans=new ArrayList<>();
        List<String> cur=new LinkedList<>();
        char []c=s.toCharArray();
        back2(c,s,0,cur);
        return ans;
    }
    private void back2(char []c,String s,int start,List<String> cur){
        if(start==c.length){
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = start+1; i <=c.length ; i++) {
            if(isHuiWen2(c,start,i-1)){
                cur.add(s.substring(start,i));
                back2(c,s,i,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isHuiWen2(char []c,int start,int end){
        while (start<end){
            if(c[start]!=c[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
