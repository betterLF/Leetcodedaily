package Array;

/**
 * @authtor liFei
 * @date 2020/5/8-7:51
 */
public class Solution667 {
    /*
    给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
中应该有且仅有 k 个不同整数；.
② 如果存在多种答案，你只需实现并返回其中任意一种.
     */
    public int[] constructArray(int n, int k) {
               int ans[]=new int[n];
               int left=n-k;
               int right=n;
               int count=0;
               for (int i=1;i<left;i++){
                   ans[count++]=i;
               }
               while (count!=n){
                   ans[count++]=left++;
                   if(count!=n) {
                       ans[count++] = right--;
                   }
               }
               return ans;
    }
}
