package String;

/**
 * @authtor liFei
 * @date 2020/5/25-7:22
 */
public class Solution14 {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
     */
    public static void main(String[] args) {
        String[] s={"",""};
        longestCommonPrefix(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
          StringBuilder ans=new StringBuilder();
          int minLength=100;
        for (int i = 0; i <strs.length ; i++) {
            minLength=Math.min(minLength,strs[i].length());
        }
        for (int i = 0; i <minLength ; i++) {
            if(isSame(strs,i)){
                ans.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return ans.toString();
    }
    private static boolean isSame(String[] strs,int index){
        char cur=strs[0].charAt(index);
        for (int i = 1; i <strs.length ; i++) {
            if(cur!=strs[i].charAt(index)){
                return false;
            }
        }
        return true;
    }
}
