package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/4-8:58
 */
public class Solution118 {
    /*
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans=new ArrayList<>();
         if(numRows==0){
             return ans;
         }
         List<Integer> temp=new ArrayList<>();
         temp.add(1);
        ans.add(temp);
         if(numRows==1){
             return ans;
         }
        List<Integer> temp2=new ArrayList<>();
        temp2.add(1);
        temp2.add(1);
        ans.add(temp2);
        if(numRows==2){
            return ans;
        }
        for (int i = 3; i <=numRows ; i++) {
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            List<Integer> c=ans.get(i-2);
            for (int j = 0; j <c.size()-1 ; j++) {
                cur.add(c.get(j)+c.get(j+1));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
