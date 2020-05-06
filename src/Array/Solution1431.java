package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/5-6:26
 */
public class Solution1431 {
    /*
    给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
注意，允许有多个孩子同时拥有 最多 的糖果数目。
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
              int max=0;
              for(int cur:candies){
                  if(cur>max){
                      max=cur;
                  }
              }
              List<Boolean> ans=new ArrayList<>();
              for (int cur:candies){
                  if(cur+extraCandies>=max){
                      ans.add(true);
                  }else{
                      ans.add(false);
                  }
              }
              return ans;
    }
}
