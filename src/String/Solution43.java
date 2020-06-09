package String;

/**
 * @authtor liFei
 * @date 2020/6/6-10:48
 */
public class Solution43 {
    /*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public static void main(String[] args) {
        System.out.println(multiply("557999993","9841112312"));
    }
    public static String multiply(String num1, String num2) {
             int len1=num1.length();
             int len2=num2.length();
             if(num1.equals("0")||num2.equals("0")){
                 return "0";
             }
             int []ans=new int[len1+len2];
             char []c1=num1.toCharArray();
             char []c2=num2.toCharArray();
             int startIndex=ans.length-1;
             int C=0;//进位标志符
        for (int i = c2.length-1; i>=0 ; i--) {
            int curStart=startIndex;
            int curNum=c2[i]-'0';
            for (int j =c1.length-1;j>=0 ; j--) {//每次for循环结束后算出每一行的值
                ans[curStart]+=C+(c1[j]-'0')*curNum;
                C=ans[curStart]/10;//进位
                ans[curStart]%=10;//取余
                curStart--;//下一个位置进行运算
            }
            if(C!=0){
                ans[curStart]=C;
                C=0;
            }
            startIndex--;
        }
          StringBuilder res=new StringBuilder();
        for (int i = 0; i <ans.length ; i++) {
            if(ans[i]!=0){
                while (i<ans.length){
                    res.append(ans[i]);
                    i++;
                }
            }
        }
        return res.toString();
    }
}
