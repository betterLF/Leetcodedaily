package String;

/**
 * @authtor liFei
 * @date 2020/7/3-8:54
 */
public class Solution387 {
    /*
     给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */
    public int firstUniqChar(String s) {
          int []count=new int[26];
        char []c=s.toCharArray();
          for (char cur:c){
              count[cur-'a']++;
          }
          for(int i=0;i<c.length;i++){
              if(count[c[i]-'a']==1){
                  return i;
              }
          }
          return -1;
    }
}
