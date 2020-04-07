import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
   public List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
         for(int i=0;i<nums.length;i++){
             List<List<Integer>> resNow=new LinkedList<>();
             for(List<Integer> cur:res){
                List<Integer> c=new ArrayList<>(cur);
                c.add(nums[i]);
                 Collections.sort(c);
                resNow.add(c);
             }
             for(List<Integer> cur:resNow){
              if(res.contains(cur)){
                  continue;
              }else{
                  res.add(cur);
              }
             }
         }
         return res;
    }
}
