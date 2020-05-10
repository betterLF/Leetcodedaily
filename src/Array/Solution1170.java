package Array;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/5/8-7:16
 */
public class Solution1170 {
    /*

我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //可以对words值排序后用二分简化
        int len=words.length;
        int count[]=new int[len];
        for (int i=0;i<len;i++){
            count[i]=countNumber(words[i]);
        }
        Arrays.sort(count);
        int len2=queries.length;
        int ans[]=new int[len2];
        for (int i = 0; i <len2; i++) {
            ans[i] = count(countNumber(queries[i]), count);
        }
        return ans;
    }
    private int countNumber(String s){
        int temp[]=new int[26];
        for(char c:s.toCharArray()){
            temp[c-'a']++;
        }
        for (int i=0;i<26;i++){
            if(temp[i]!=0){
                return temp[i];
            }
        }
        return 0;
    }
    private int count(int value,int c[]){
        int left=0;
        int right=c.length-1;
        while (left<right){
            int mid=(left+right+1)/2;
            if(c[mid]<=value){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        if(c[left]<=value){
            return c.length-left-1;
        }
        return c.length-left;

    }
}
