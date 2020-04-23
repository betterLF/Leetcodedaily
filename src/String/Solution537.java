package String;

/**
 * @authtor liFei
 * @date 2020/4/22-15:13
 */
public class Solution537 {
    /*
给定两个表示复数的字符串。
返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
     */
    public static void main(String[] args) {
        complexNumberMultiply( "1+-1i","0+0i");
    }
    public static String complexNumberMultiply(String a, String b) {
        char aa[]= a.toCharArray();
        char bb[]=b.toCharArray();
        int temp1=0;
        int temp2=0;
        for (int i = 0; i <aa.length ; i++) {
            if(aa[i]=='+'){
                temp1=i;
                break;
            }
        }
        for (int i = 0; i <bb.length ; i++) {
            if(bb[i]=='+'){
                temp2=i;
                break;
            }
        }
          int a1=Integer.parseInt(a.substring(0,temp1));
          int a2=Integer.parseInt(a.substring(temp1+1,a.length()-1));
          int b1=Integer.parseInt(b.substring(0,temp2));
          int b2=Integer.parseInt(b.substring(temp2+1,b.length()-1));
        StringBuilder ans=new StringBuilder();
        int res1=a1*b1-a2*b2;
        int res2=a1*b2+a2*b1;
        ans.append(""+res1+'+'+res2+'i');
        return ans.toString();
    }
    public String complexNumberMultiply2(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }
}
