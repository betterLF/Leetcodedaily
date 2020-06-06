package Bitwise;

/**
 * @authtor liFei
 * @date 2020/6/4-19:11
 */
public class Solution29 {
    /*
    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     */
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,2));
    }
    public static int divide(int dividend, int divisor) {
        long dividend1=dividend;
        long divisor1=divisor;
        if(dividend==-2147483648&&divisor==-1){
            return 2147483647;
        }
        int flag=-1;
        if((dividend>=0&&divisor>0)||(dividend<=0&&divisor<0)){
            flag=1;
        }
        dividend1=Math.abs(dividend1);
        divisor1=Math.abs(divisor1);
        int ans=0;
        if(dividend1<divisor1){
            return ans;
        }
        while (true){
            int temp=0;
            for (int i = 0; i <32 ; i++) {
                if ((divisor1 << i) <= dividend1 && (divisor1 << (i + 1) > dividend1)) {
                    temp = i;//找到此时被除数有多少个2的i次方的除数
                    break;
                }
            }
            if(temp==0){//如果temp=0,则此时被除数>1=1倍的除数，小于两倍的除数，此时的ans就是结果，直接退出循环
                ans++;
                break;
            }else{
                ans+=(1<<temp);//当前结点加入
                dividend1-=(divisor1<<temp);
                if(dividend1<divisor1){//如果刚好除尽，就返回结果
                    break;
                }
            }
        }
        return flag*ans;
    }
    //二分优化
    public static int divide2(int dividend, int divisor) {
        long dividend1=dividend;
        long divisor1=divisor;
        if(dividend==-2147483648&&divisor==-1){
            return 2147483647;
        }
        int flag=-1;
        if((dividend>=0&&divisor>0)||(dividend<=0&&divisor<0)){
            flag=1;
        }
        dividend1=Math.abs(dividend1);
        divisor1=Math.abs(divisor1);
        int ans=0;
        if(dividend1<divisor1){
            return ans;
        }
        int max=32;
        while (true){
            int temp=0;
            int left=0;
            int right=max;
            while (left<right){
                int mid=left+(right-left)/2;
                if((divisor1 << mid) <= dividend1 && (divisor1 << (mid + 1) > dividend1)){
                    left=mid;
                    break;
                }else if((divisor1 << mid) <dividend1){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            temp=left;
            max=temp+1;//下次二分的右边界
            if(temp==0){//如果temp=0,则此时被除数>1=1倍的除数，小于两倍的除数，此时的ans就是结果，直接退出循环
                ans++;
                break;
            }else{
                ans+=(1<<temp);//当前结点加入
                dividend1-=(divisor1<<temp);
                if(dividend1<divisor1){//如果刚好除尽，就返回结果
                    break;
                }
            }
        }
        return flag*ans;
    }
}
