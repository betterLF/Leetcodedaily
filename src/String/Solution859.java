package String;

/**
 * @authtor liFei
 * @date 2020/9/7-7:59
 */
public class Solution859 {
    /*
    给定两个由小写字母构成的字符串 A 和 B ，
    只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
     */
    public boolean buddyStrings(String A, String B) {
            if(A.length()!=B.length()){
                return false;
            }
            if(A.equals(B)){
                int []count=new int[26];
                for (int i = 0; i <A.length() ; i++) {
                    int cur=A.charAt(i)-'a';
                    count[cur]++;
                    if(count[cur]>=2){
                        return true;
                    }
                }
                return false;
            }
            int dif_count=0;
            int preIndex=-1;
            int preIndex02=-1;
        for (int i = 0; i <A.length() ; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                dif_count++;
                if (dif_count == 1) {
                    preIndex = i;
                } else {
                    preIndex02 = i;
                }
            }
        }
            if (dif_count!=2) {
                return false;
            }
            if(A.charAt(preIndex)==B.charAt(preIndex02)&&A.charAt(preIndex02)==B.charAt(preIndex)){
                return true;
            }
            return false;
        }

}
