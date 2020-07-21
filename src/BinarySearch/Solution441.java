package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/7/18-8:03
 */
public class Solution441 {
    /*
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。
     */
    public int arrangeCoins(int n) {
         int left=1;
         int right=n;
         while (left<=right){
             int mid=left+(right-left)/2;
            long curAns=(1+mid)*mid /2;
             if(curAns>n){
                 right=mid-1;
             }else if(curAns<n){
                 left=mid+1;
             }else{
                 return mid;
             }
         }
         return left-1;
    }
    public int arrangeCoins2(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
