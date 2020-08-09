package String;

/**
 * @authtor liFei
 * @date 2020/8/7-7:15
 */
public class Solution541 {
    /*
    给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     */
    public String reverseStr(String s, int k) {
            char c[]=s.toCharArray();
            int i;
        for (i = 0; i <s.length() ; i+=2*k) {
            reverse(c,i,i+k-1);
        }
        reverse(c,i,s.length()-1);
            return new String(c);
    }
    private void reverse(char []c,int start,int end){
        if(end>=c.length){
            end=c.length-1;
        }
        while (start<end){
            char cur=c[start];
            c[start]=c[end];
            c[end]=cur;
            start++;
            end--;
        }
    }
}
