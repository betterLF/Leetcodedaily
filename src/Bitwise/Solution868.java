package Bitwise;

/**
 * @authtor liFei
 * @date 2020/9/8-18:06
 */
public class Solution868 {
    /*
    给定一个正整数 N，找到并返回 N 的二进制表示中两个相邻 1 之间的最长距离。
如果没有两个相邻的 1，返回 0 。
     */
    public int binaryGap(int N) {
         if(N==Integer.MAX_VALUE){
             return 1;
         }
         int maxCount=31;
        for (; maxCount>=0; maxCount--) {
            if((N-(1<<maxCount))>=0){
                     break;
            }
        }
        int pre=-1;
        int ans=0;
        for (int i =maxCount; i>=0 ; i--) {
            if((N&(1<<i))!=0){
                if(pre==-1){
                    pre=i;
                }else{
                    ans=Math.max(ans,pre-i);
                    pre=i;
                }
            }
        }
        return ans;
    }
}
