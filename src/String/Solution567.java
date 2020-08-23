package String;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/8/21-6:54
 */
public class Solution567 {
    /*
    给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，第一个字符串的排列之一是第二个字符串的子串。
     */
    public boolean checkInclusion(String s1, String s2) {
          int []countArr=new int[26];
          int count=s1.length();
          for (char c:s1.toCharArray()){
              countArr[c-'a']++;
          }
          int left=0;
          int right=0;
          int []copy= Arrays.copyOf(countArr,countArr.length);
          while (count!=0&&right<s2.length()){
              char cur=s2.charAt(right);
              if(copy[cur-'a']>0){//如果该字符出现在s1里面并且没有遍历到
                  count--;
                  copy[cur-'a']--;
              }else if(count!=s1.length()) {
                  if (countArr[cur - 'a'] > 0) {//该子符在s1里面
                      for (int j = left; j < right; j++) {
                          char cc = s2.charAt(j);
                          if (cur == cc) {
                              left = j + 1;//开始位置更新
                              break;
                          }
                          if (countArr[cc - 'a'] > 0) {
                              copy[cc - 'a']++;
                              count++;
                          }
                      }
                  } else {//该字符不在字符串s1里面，重置运算
                      count = s1.length();
                      copy = Arrays.copyOf(countArr, countArr.length);
                      left=right+1;
                  }
              }
              right++;
          }
          return count==0;
    }
}
