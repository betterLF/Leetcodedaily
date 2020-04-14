package Bitwise;

/**
 * @authtor liFei
 * @date 2020/4/14-9:31
 */
public class Solution1601ms {
    /*
    编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
     */
    public int[] swapNumbers(int[] numbers) {
            numbers[0]=numbers[0]+numbers[1];
            numbers[1]=numbers[0]-numbers[1];
            numbers[0]=numbers[0]-numbers[1];
            //位运算
//            numbers[0] ^= numbers[1];//求两个数的异或和
//            numbers[1] ^= numbers[0];//对和进行异或得到相反结果
//            numbers[0] ^= numbers[1];
            return numbers;
    }
}
