import java.util.Arrays;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution7 {
    public static int reverse(int x) {
        int abs=x;
        if(x==(-(int)Math.pow(2,30))*2){
            return 0;
        }else if(x<0&&x!=(-(int)Math.pow(2,30))*2){
               abs=Math.abs(x);
        }
        String s=Integer.toString(abs);
        char res[]=s.toCharArray();
        char temp=' ';
        StringBuilder sb=new StringBuilder();
        for(int i=res.length-1;i>=0;i--){
            sb.append(res[i]);
        }
        String ss=sb.toString();
        String sss=Integer.toString(Integer.MAX_VALUE);
        if(ss.length()==sss.length()){
            for(int i=0;i<ss.length();i++){
                if(ss.charAt(i)>sss.charAt(i)){
                    return 0;
                }else if(ss.charAt(i)<sss.charAt(i)){
                    break;
                }
            }
        }
        int result=Integer.parseInt(ss);
              if(x<0){
                  result=-result;
              }
             return result;
    }
   //!别人的思路，时间复杂度超100%
    public static int reverse2(int x) {
        int res = 0 ;
        while(x != 0){
            int temp = x % 10 + res * 10;
            if((temp - x % 10) / 10 != res){ //若上一步res*10超出2的31次方-1范围，则temp就不是真值，求反操作就会出错
                return 0 ;
            }
            res = temp ;
            x /= 10 ;
        }
        return res ;
    }

}
