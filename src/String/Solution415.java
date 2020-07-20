package String;

/**
 * @authtor liFei
 * @date 2020/7/17-8:53
 */
public class Solution415 {
    /*
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
         int len1=num1.length()-1;
         int len2=num2.length()-1;
         StringBuilder ans=new StringBuilder();
         int c=0;//进位
        while (len1>=0&&len2>=0){
            int curAns=num1.charAt(len1)-'0'+num2.charAt(len2)-'0'+c;
            if(curAns>=10){
                c=1;
                ans.append(curAns-10);
            }else{
                c=0;
                ans.append(curAns);
            }
            len1--;
            len2--;
        }
        if(len1>=0){
            while (len1>=0){
                int curAns=num1.charAt(len1)-'0'+c;
                if(curAns>=10){
                    c=1;
                    ans.append(curAns-10);
                }else{
                    c=0;
                    ans.append(curAns);
                }
                len1--;
            }
        }
        if(len2>=0){
            while (len2>=0){
                int curAns=num2.charAt(len1)-'0'+c;
                if(curAns>=10){
                    c=1;
                    ans.append(curAns-10);
                }else{
                    c=0;
                    ans.append(curAns);
                }
                len2--;
            }
        }
        if(c==1){
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
