package String;

/**
 * @authtor liFei
 * @date 2020/7/20-8:15
 */
public class Solution459 {
    /*
    给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        for (int i = len/2; i >=1 ; i--) {
            if(len%i!=0){
                continue;
            }
            String cur=s.substring(0,i);
            boolean flag=false;
            for (int j =i; j <len ; j+=i) {
                if(!cur.equals(s.substring(j,j+i))){
                    flag=true;
                       break;
                }
            }
            if(!flag){
                return true;
            }
        }
        return false;
    }
}
