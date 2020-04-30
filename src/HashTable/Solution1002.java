package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/28-8:43
 */
public class Solution1002 {
    /*
    给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
    例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
你可以按任意顺序返回答案。
     */
    //方法一：
    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<>();
        List<int[]> ans=new ArrayList<>();
        int len=A.length;
        for (int i=0;i<26;i++){
            int cur[]=new int[len];
            ans.add(cur);
        }
        for (int i = 0; i <A.length ; i++) {
            solve(A[i],ans,i);
        }
        for (int i=0;i<ans.size();i++){
            Arrays.sort(ans.get(i));
            int min=ans.get(i)[0];
            char c=(char)(i+'a');
            while (min!=0){
                res.add(""+c);
                min--;
            }
        }
         return res;
    }
    private void solve(String a,List<int[]> ans,int index){
        for (char cur:a.toCharArray()){
            ans.get(cur-'a')[index]++;
        }
    }
    //方法二：
    public List<String> commonChars2(String[] A) {
        if (A == null || A.length == 0) return null;

        List<String> rs = new LinkedList<>();
        int[] res = getCharList(A[0]);

        for (int i = 1; i < A.length;i ++){
            res = bingji(res, getCharList(A[i]));
        }

        for (int i = 0;i < 26;i ++){
            while (res[i]-- > 0){
                rs.add(String.valueOf((char)('a' + i)));
            }
        }
        return rs;
    }

    public int[] getCharList(String s){
        int[] res = new int[26];
        for (char c:s.toCharArray()){
            res[c - 'a'] ++;
        }
        return res;
    }

    public int[] bingji(int[] res1, int[] res2){
        for (int i = 0;i < res1.length;i ++){
            res1[i] = res1[i] < res2[i] ? res1[i] : res2[i];
        }
        return res1;
    }
}
