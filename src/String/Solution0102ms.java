package String;

public class Solution0102ms {
    /*
    给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     */
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int res1[]=new int[256];
        int res2[]=new int[256];
        for(int i=0;i<s1.length();i++){
            res1[s1.charAt(i)]++;
            res2[s2.charAt(i)]++;
        }
        int count=s1.length();
        for(int i=0;i<256;i++){
            if(res1[i]==res2[i]){
                count-=res1[i];
            }else{
                break;
            }
            if(count==0){
                return true;
            }
        }
        return false;
    }
}
