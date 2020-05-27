package String;

/**
 * @authtor liFei
 * @date 2020/5/25-11:31
 */
public class Solution28 {
    /*
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    public static void main(String[] args) {
KMP("mississippi");
    }
    /*
    "aabaaabaaac"
"aabaaac"*/
    public static int strStr(String haystack, String needle) {
             if(needle.isBlank()){
                 return 0;
             }
             int len=needle.length();
             int []rNext=KMP(needle);
             int j=0;//needle字符串的索引
        for (int i = 0; i <haystack.length() ; ) {
                    if(haystack.charAt(i)==needle.charAt(j)){
                        if(j==len-1){
                            return i-len+1;
                        }
                        j++;
                        i++;
                    }else{
                        if(j!=0) {
                            j = rNext[j - 1];
                        }else{
                            i++;
                        }
                    }
        }
        return -1;
    }
    private static int[] KMP(String needle){
        int len=needle.length();
        int[] ans=new int[len];
        ans[0]=0;
        int temp=0;
        for (int i = 1; i <len ; i++) {
                if(needle.charAt(i)==needle.charAt(temp)){
                    ans[i]=temp+1;
                    temp++;
                }else {
                    int n = i - temp + 1;
                    int cc = 0;
                    while (n<len&&needle.charAt(n) == needle.charAt(cc) && n <= i) {
                        cc++;
                        n++;
                    }
                    if (n == i + 1) {
                        ans[i] = temp;
                    } else {
                        temp=0;
                        if (needle.charAt(i) == needle.charAt(temp)) {
                            ans[i] = 1;
                            temp++;
                        }
                    }
                }
        }
        return ans;
    }
    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
