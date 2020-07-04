package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/7/2-6:23
 */
public class Solution345 {
    /*
    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     */
    public String reverseVowels(String s) {
        char []c=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while (i<j){
            while(i<j&&!isTarget(c[i])){
                i++;
            }
            while (j>i&&!isTarget(c[j])){
                j--;
            }
            if(i<j&&isTarget(c[i])&&isTarget(c[j])){
                char temp=c[i];
                c[i]=c[j];
                c[j]=temp;
            }
            i++;
            j--;
        }
//        StringBuilder ans=new StringBuilder();
//        for (char cur:c){
//            ans.append(cur);
//        }
//        return ans.toString();
        return new String(c);
    }
    private boolean isTarget(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
