package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/22-15:45
 */
public class Solution1711ms {
    /*
    有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
    如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     */
    public int findClosest(String[] words, String word1, String word2) {
      int count=-1;
      int count2=-1;
      int ans=Integer.MAX_VALUE;
      for (int i=0;i<words.length;i++) {
          if (word1.equals(words[i])) {
              count = i;
              if(count2!=-1){
                  ans = Math.min(ans, Math.abs(count - count2));
                  if(ans==1){
                      return ans;
                  }
              }
          } else if (word2.equals(words[i])) {
              count2 = i;
              if(count!=-1){
                  ans = Math.min(ans, Math.abs(count - count2));
                  if(ans==1){
                      return ans;
                  }
              }
          }

      }
      return ans;
    }
}
