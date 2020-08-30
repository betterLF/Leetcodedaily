package String;

/**
 * @authtor liFei
 * @date 2020/8/28-9:33
 */
public class Solution686 {
    /*
    给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
举个例子，A = "abcd"，B = "cdabcdab"。
答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     */
    public int repeatedStringMatch(String A, String B) {
         StringBuilder cur=new StringBuilder(A);
         int curB_Length=B.length();
         int ans=1;
         while (cur.length()<curB_Length){
             cur.append(A);
             ans++;
         }
         if(cur.lastIndexOf(B)!=-1){
             return ans;
         }
         if(cur.append(A).lastIndexOf(B)!=-1){
             return ans+1;
         }
         return -1;
    }
}
