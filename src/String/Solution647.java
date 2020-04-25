package String;

/**
 * @authtor liFei
 * @date 2020/4/23-20:10
 */
public class Solution647 {
    /*
    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     */
    public int countSubstrings(String s) {
        int count=0;
        int length=0;
        int len=s.length();
        char c[]=s.toCharArray();
        while (length!=len){
            for(int i=0;i<len-length;i++){
                if(isRight(c,i,i+length)){
                    count++;
                }
            }
            length++;
        }
        return count;
    }
    private  boolean isRight(char c[],int start,int end){
        int temp=end;
        for (;start<=temp;start++,end--){
            if(!(c[start]==c[end])){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings2(String s) {
        int count=0;
        int len=s.length();
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            int left=i-0;
            int right=i+0;
            while (left>=0&&right<=len-1){//奇数位判断是否回文
                if(c[left]==c[right]){
                    count++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
               if(i+1<=c.length-1&&c[i]==c[i+1]){//偶数位判断是否回文
                   count++;
                   int left2=i-1;
                   int right2=i+2;
                   while (left2>=0&&right2<=len-1){
                       if(c[left]==c[right]){
                           count++;
                           left2--;
                           right2++;
                       }else{
                           break;
                       }
                   }
               }
        }
        return count;
    }
    public int countSubstrings3(String s) {
        int count=0;
        int len=s.length();
        char c[]=s.toCharArray();
        for(int i=0;i<2*c.length;i++){
            int left=i/2;
            int right=left+i%2;//i为奇数时是判断偶数位回文子串，i为偶数时是判断奇数位回文子串
            while (left>=0&&right<=len-1&&c[left]==c[right]){
                if(c[left]==c[right]){
                    count++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
