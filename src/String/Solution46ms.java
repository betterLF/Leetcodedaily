package String;

/**
 * @authtor liFei
 * @date 2020/6/9-8:04
 */
public class Solution46ms {
    /*
    给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
    一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        char[]c=String.valueOf(num).toCharArray();
        if(c.length==1){
            return 1;
        }
        int []dp=new int[c.length];
        dp[0]=1;
        if(c[0]=='1'||(c[0]=='2'&&c[1]-'5'<=0)){
            dp[1]=2;
        }else{
            dp[1]=1;
        }
        for (int i = 2; i <dp.length; i++) {
            if(c[i-1]=='1'||(c[i-1]=='2'&&c[i]-'5'<=0)){//如果该值和前面值也可以代表一个字母，该值=前值+1，否则等于前值
                  dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
