package Math;

/**
 * @authtor liFei
 * @date 2020/6/7-17:05
 */
public class Solution50 {
    /*
    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     */
    public static void main(String[] args) {
        myPow(0.00001,2147483647);
    }
    public static double myPow(double x, int n) {
        if(Math.abs(x-1)<0.000000001){//如果是1，直接返回
            return x;
        }
            double ans=1.0;
            long num=n;
//            if(num>0){
//                while (num!=0) {
//                    double curAns=x;
//                    long curNum=1;
//                    while (curNum*2 < num) {
//                        curAns *= curAns;
//                        curNum *=2;
//                    }
//                    num-=curNum;
//                    ans*=curAns;
//                }
//            }else{
//                num=-num;
//                while (num!=0) {
//                    double curAns=x;
//                    long curNum=1;
//                    while (curNum*2 < num) {
//                        curAns *= curAns;
//                        curNum *= 2;
//                    }
//                    num-=curNum;
//                    ans*=curAns;
//                }
//                ans=1.0/ans;
//            }
        boolean flag=num>0?true:false;
        num=Math.abs(num);
        while (num!=0) {
            double curAns=x;
            long curNum=1;
            while (curNum*2 < num) {
                curAns *= curAns;
                curNum *=2;
            }
            num-=curNum;
            ans*=curAns;
        }
            return flag==true?ans:1.0/ans;
    }
}
