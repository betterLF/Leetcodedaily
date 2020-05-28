package String;

/**
 * @authtor liFei
 * @date 2020/5/26-19:05
 */
public class Solution38 {
    /*

     */
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
           return toString(n);
    }
    private static String toString(int n){
        if(n==1){
            return "1";
        }else{
            String temp=toString(n-1);
            char[] c=temp.toCharArray();
            StringBuilder ans=new StringBuilder();
            for (int i = 0; i <c.length ; ) {
                       int j=i+1;
                       while (j<c.length&&c[j]==c[i]){
                           j++;
                       }
                       ans.append(j-i).append(c[i]);
                       i=j;
            }
            return ans.toString();
        }
    }
}
