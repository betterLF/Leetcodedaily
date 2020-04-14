package Bitwise;

/**
 * @authtor liFei
 * @date 2020/4/14-9:11
 */
public class Solution1342 {
    /*
    给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
     */
    public int numberOfSteps (int num) {
        int count=0;
        while(num!=0){
          num=num%2==0?num/2:num-1;
          //num = (num & 1) == 0 ? num >> 1: num & -2 ;位运算
          count++;
      }
      return count;
    }
}
