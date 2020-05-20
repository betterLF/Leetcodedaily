package String;

/**
 * @authtor liFei
 * @date 2020/5/19-6:34
 */
public class Solution680 {
    /*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     */
    public boolean validPalindrome(String s) {
           char []cur=s.toCharArray();
           int i=0;
           int j=cur.length-1;
           while (i<j){
               if(cur[i]==cur[j]){
                   i++;
                   j--;
               }else{
                   return isRight(cur,i,j-1)||isRight(cur,i+1,j);
               }
           }
           return true;
    }
    private boolean isRight(char []c,int i,int j){
        while (i<j){
            if(c[i]==c[j]){
                i++;
                j--;
            }else{
             return false;
            }
        }
        return true;
    }

}
