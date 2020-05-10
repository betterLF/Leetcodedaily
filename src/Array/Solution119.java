package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/8-7:04
 */
public class Solution119 {
    /*
    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     */
    public List<Integer> getRow(int rowIndex) {
          List<Integer> ans=new ArrayList<>();
          if(rowIndex==0){
              ans.add(1);
              return ans;
          }
          int cur[]=new int[rowIndex+1];
          cur[0]=1;
          cur[1]=1;
          for (int i=3;i<=rowIndex+1;i++){
              cur[i-1]=1;
              for (int j=i-2;j>0;j--){
                  cur[j]=cur[j]+cur[j-1];
              }
              cur[0]=1;
          }
         for (int i=0;i<rowIndex+1;i++){
             ans.add(cur[i]);
         }
         return ans;
    }
}
