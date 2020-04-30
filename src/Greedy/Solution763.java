package Greedy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/24-7:59
 */
public class Solution763 {
    /*
    字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
    同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans=new ArrayList<>();
        char c[]=S.toCharArray();
        int start=0;
        int temp=start;
        int end=c.length-1;
        for(;start<=end;) {
            if (c[end] != c[start]) {
                end--;
            }else{
                for (int i=end;i<c.length;i++){
                    if(isNotContains(c,start,i)){
                        ans.add(i-start+1);
                        start=i+1;
                        end=c.length-1;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    private boolean isNotContains(char cur[],int start,int end){
        HashSet<Character> a=new HashSet<>();
        for(int i=start;i<end;i++){
            a.add(cur[i]);
        }
        for (int i=end+1;i<cur.length;i++){
            if(a.contains(cur[i])){
                return false;
            }
        }
        return true;
    }
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];//last表示当前数组中每个字符出现的最后下标
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        int j = 0, start = 0;//start表示当前字符的首部，j表示当前出现的所有字符中最后出现字符位置的最大下标
        List<Integer> ans = new ArrayList();
        char c[]=S.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            j = Math.max(j, last[c[i] - 'a']);//如果当前字符出现的最后位置>j,就更新j
            if (i == j) {//如果i==j,表明此时i位置是前面所有字符的最后出现位置的最大值
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
