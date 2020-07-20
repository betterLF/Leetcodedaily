package String;

/**
 * @authtor liFei
 * @date 2020/7/18-7:11
 */
public class Solution434 {
    /*
    统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
     */
    public int countSegments(String s) {
       int ans=0;
       char []c=s.toCharArray();
       boolean flag=false;
        for (int i = 0; i <c.length ; i++) {
            if(c[i]!=' '){
                flag=true;
            }else{
                if(flag){
                    ans++;
                    flag=false;
                }
            }
        }
        if(flag){
            ans++;
        }
        return ans;
    }
}
