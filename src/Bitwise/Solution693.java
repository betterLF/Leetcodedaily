package Bitwise;

/**
 * @authtor liFei
 * @date 2020/8/29-12:04
 */
public class Solution693 {
    /*
给定一个正整数，检查他是否为交替位二进制数：
换句话说，就是他的二进制数相邻的两个位数永不相等。
     */
    public boolean hasAlternatingBits(int n) {
        int count=0;
        for (int i = 31; i >=0 ; i--) {
            if((n&(1<<i))!=0){
                count=i;
                break;
            }
        }
        boolean flag=true;
        while (count!=-1){
            if(flag){
                if((n&(1<<count))==0){
                    return false;
                }
                flag=false;
            }else{
                if((n&(1<<count))!=0){
                    return false;
                }
                flag=true;
            }
            count--;
        }
        return true;
    }
}
