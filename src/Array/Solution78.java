import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    //同面试0804，方法不同
    public static List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> res=new LinkedList<>();
        res.add(new ArrayList<Integer>());//将空集加入
        for(int num:nums){
            List<List<Integer>> cur=new ArrayList<>();
            for(List<Integer> past:res){
              List<Integer> a=new ArrayList<Integer>(past);
              a.add(num);
              cur.add(a);
              //cur.add(new ArrayList<Integer>(past){{add(num);}});//将第一(二，三。。)个元素加入,如原本为空，加个1，原本为空，1加个2
            }
                     for(List<Integer> now:cur){
                         res.add(now);//将cur里的集合依次加入结果集中
                     }
    }
        return res;
    }
}
