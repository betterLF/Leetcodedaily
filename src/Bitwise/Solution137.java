package Bitwise;

/**
 * @authtor liFei
 * @date 2020/6/16-8:07
 */
public class Solution137 {
    /*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public int singleNumber(int[] nums) {
        int x=0;
        int y=0;
        for (int num : nums) {
          int temp1=x;
          int temp2=y;
          x=((~num)&temp1)|(num&temp2);
          y=(~temp1)&(num^temp2);
        }
        return y;
    }
}
