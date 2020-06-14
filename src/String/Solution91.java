package String;

/**
 * @authtor liFei
 * @date 2020/6/11-17:17
 */
public class Solution91 {
    /*
    一条包含字母 A-Z 的消息通过以下方式进行了编码：
     */
    public int numDecodings(String s) {
         char []c=s.toCharArray();
         int []dp=new int[c.length];
         if(dp.length==0){
             return 0;
         }else if(dp.length==1){
             return c[0]=='0'?0:1;
         }
         dp[0]=c[0]=='0'?0:1;
         if(c[0]=='0'||(c[1]=='0'&&c[0]>'2')){//如果第一位是0，第一位无法编码或者第二位为0，第一位大于2，无论后面是什么，都无法编码成功。
             return 0;
         }
        if((c[0]=='2'&&c[1]<'7'&&c[1]!='0')||(c[0]=='1'&&c[1]!='0')) {
            dp[1] = 2;
        }else {
             dp[1]=1;
        }
        for (int i = 2; i <dp.length ; i++) {
            if((c[i-1]=='2'&&c[i]<'7'&&c[i]!='0')||(c[i-1]=='1'&&c[i]!='0')){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                if(c[i]=='0'&&(c[i-1]>'2'||c[i-1]=='0')){//无法编码
                    return 0;
                }
                if(c[i]=='0') {
                    dp[i] = dp[i - 2];
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[dp.length-1];
    }
}
