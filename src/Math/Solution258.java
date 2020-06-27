package Math;

/**
 * @authtor liFei
 * @date 2020/6/24-8:32
 */
public class Solution258 {
    /*
    给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     */
    public int addDigits(int num) {
             int cur=num;
             while (cur>10){
                 int temp=0;
                 while (cur>10){
                     temp+=cur%10;
                     cur/=10;
                 }
                 temp+=cur%10;
                 cur=temp;
             }
             return cur;
    }
}
