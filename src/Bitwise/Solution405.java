package Bitwise;

/**
 * @authtor liFei
 * @date 2020/7/16-18:46
 */
public class Solution405 {
    /*
    给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
注意:
十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
     */
    StringBuilder ans;
    boolean flag;
    public String toHex(int num) {
        ans=new StringBuilder();
        flag=false;
        int count=0;
        int curAns=0;
        for (int i = 31; i>=0 ; i--) {
            int cur=(num&(1<<i))==0?0:1;
            curAns+=cur*(int)Math.pow(2,3-count);
            count++;
            if(count==4){
                turn(curAns);
                curAns=0;
                count=0;
            }
        }
        if(ans.length()==0){
            return "0";
        }
        return ans.toString();
    }
    private void turn(int cur){
        if(cur==0){
            if(flag){
                ans.append(cur);
            }
            return;
        }
        //   System.out.println(cur);
        if(cur<10){
            ans.append(cur);
            flag=true;
        }else {
            ans.append((char) ('a' + (cur - 10)));
            flag=true;
        }
    }
}
