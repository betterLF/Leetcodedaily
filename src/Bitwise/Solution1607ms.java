package Bitwise;

/**
 * @authtor liFei
 * @date 2020/4/15-9:42
 */
public class Solution1607ms {
    /*
    编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
     */
    public int maximum(int a, int b) {
            int arr[]={a,b};
       return arr[(int)((long)a-b>>>63)];//a-b可能超出int类型范围，于是用long类型，右移63位得到首位，首位为1表示负数，为0表示正数
    }
}
