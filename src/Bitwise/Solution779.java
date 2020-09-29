package Bitwise;

/**
 * @authtor liFei
 * @date 2020/9/26-8:05
 */
public class Solution779 {
    /*
在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
     */
    public int kthGrammar(int N, int K) {
          return dfs(N,K,0);
    }
    private int dfs(int N,int K,int bit){
        if(N==2){
          if(K==1){
              return bit==1?1:0;
          }else if(K==2){
                return bit==1?0:1;
          }
        }
        int temp=(int)Math.pow(2,N-1)/2;
        if(K>temp){
            return dfs(N-1,K-temp,bit^1);
        }else{
            return dfs(N-1,K,bit);
        }
    }
}
