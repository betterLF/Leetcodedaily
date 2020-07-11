package Sort;

/**
 * @authtor liFei
 * @date 2020/7/8-7:10
 */
public class Solution1611ms {
    /*
    你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
    你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
返回的长度需要从小到大排列。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
              if(k==0){
                  return new int[0];
              }
               if(shorter==longer){
                   int []ans={shorter*k};
                   return ans;
               }
               int []ans=new int[k+1];
               int dif=longer-shorter;
               ans[0]=k*shorter;
        for (int i = 1; i <ans.length ; i++) {
            ans[i]=ans[i-1]+dif;
        }
        return ans;
    }
}
