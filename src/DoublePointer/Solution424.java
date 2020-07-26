package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/7/24-6:21
 */
public class Solution424 {
    /*
    给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
    总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
注意:
字符串长度 和 k 不会超过 104。
     */
    public int characterReplacement(String s, int k) {
           if(s.length()==0){
               return 0;
           }
           int left=0;
           int right=0;
           char []c=s.toCharArray();
           int []map=new int[26];
           int historyMax=0;
        for (;  right<c.length ; right++) {
            int index=c[right]-'A';
            map[index]++;
            historyMax=Math.max(map[index],historyMax);
            if(right-left+1>historyMax+k){//如果当前区间最大值加上k小于滑动窗口，则滑动窗口右移，否则窗口扩展
                map[c[left]-'A']--;
                left++;
            }
        }
        return c.length-left;
    }
}
