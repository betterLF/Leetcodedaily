package String;

/**
 * @authtor liFei
 * @date 2020/9/12-8:41
 */
public class Solution917 {
    /*
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     */
    public String reverseOnlyLetters(String S) {
            char []c=S.toCharArray();
            int left=0;
            int right=c.length-1;
            while (left<right){
                while(left<S.length()&&!((c[left]>='A'&&c[left]<='Z')||(c[left]>='a'&&c[left]<='z'))){
                    left++;
                }
                while(right>=0&&!((c[right]>='A'&&c[right]<='Z')||(c[right]>='a'&&c[right]<='z'))){
                    right--;
                }
                if(left<right){
                    char temp=c[left];
                    c[left]=c[right];
                    c[right]=temp;
                    left++;
                    right--;
                }
            }
          return new String(c);
    }
}
