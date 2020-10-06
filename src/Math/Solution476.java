package Math;

/**
 * @authtor liFei
 * @date 2020/7/21-6:32
 */
public class Solution476 {
    /*
    给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     */
    public int findComplement(int num) {
        for (int i = 31; i>=0; i--) {
            if((num&(1<<i))==0){
                continue;
            }else{
                return num^(int)(Math.pow(2,i+1)-1);
            }
        }
        return 1;//如果该值为0
    }

}
