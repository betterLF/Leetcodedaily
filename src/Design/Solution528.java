package Design;

import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/8/17-7:24
 */
public class Solution528 {
    /*
    给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，
    它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
例如，给定一个值 [1，9] 的输入列表，当我们从中选择一个数字时，很有可能 10 次中有 9 次应该选择数字 9 作为答案。
     */
    class Solution {
       int []curSum;
       Random r=new Random();
       int sum;
        public Solution(int[] w) {
           sum=0;
           curSum=new int[w.length];
           curSum[0]=w[0];
            for (int i = 1; i <w.length ; i++) {
                curSum[i]=curSum[i-1]+w[i];
            }
            sum=curSum[w.length-1];
        }

        public int pickIndex() {
            int cur=r.nextInt(sum);
            int l=0;
            int r=curSum.length-1;
            while (l!=r){
                int mid=l+(r-l)/2;
                if(curSum[mid]>cur){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
           return l;
        }
    }
}
