package Array;

/**
 * @authtor liFei
 * @date 2020/9/6-12:12
 */
public class Solution821 {
    /*
    给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
     */
    public int[] shortestToChar(String S, char C) {
        char []ss=S.toCharArray();
          int []ans=new int[ss.length];
          int pre=Integer.MIN_VALUE/2;
        for (int i = 0; i <S.length() ; i++) {
                if(ss[i]==C){
                    ans[i]=0;
                    pre=i;
                }else{
                    ans[i]=i-pre;
                }
        }
        pre=Integer.MAX_VALUE/2;
        for (int i = S.length()-1; i >=0; i--) {
            if(ss[i]==C){
                ans[i]=0;
                pre=i;
            }else{
                ans[i]=Math.min(pre-i,ans[i]);
            }
        }
        return ans;
    }
}
