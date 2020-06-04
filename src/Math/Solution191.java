package Math;

/**
 * @authtor liFei
 * @date 2020/6/2-18:50
 */
public class Solution191 {
    /*
    编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public int hammingWeight(int n) {
       int ansCount=0;
        for (int i = 0; i <32 ; i++) {
            int cur=(1<<i);
            if((n&cur)!=0){
                ansCount++;
            }
        }
        return ansCount;
    }
}
