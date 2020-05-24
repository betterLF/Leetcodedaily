package Recursion;

/**
 * @authtor liFei
 * @date 2020/5/23-7:07
 */
public class Solution0805ms {
    /*
    递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     */
    public int multiply(int A, int B) {
        return mul(A,B,0);
    }
    private int mul(int A,int B,int m){
        if(B==0){
            return m;
        }else {
            int temp = getM(B);//计算B最多可以移动几位(不小于0)
            B-=(1<<temp);//B减去A过会要增加的倍数
            m+=(A<<temp);//结果加上A移动的位数，即A乘了多少倍
         return mul(A,B,m);
        }
    }
    private int getM(int B){
        for (int i = 1; i <32 ; i++) {
            if(B>>i==0){
                return i-1;
            }
        }
        return 0;
    }
}
