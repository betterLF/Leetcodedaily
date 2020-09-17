package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/9/15-7:34
 */
public class Solution659 {
    /*
    给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
如果可以完成上述分割，则返回 true ；否则，返回 false 。
     */
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> count=new HashMap<>();
        HashMap<Integer,Integer> tail=new HashMap<>();
        for (int cur:nums) {
            count.put(cur,count.getOrDefault(cur,0)+1);
        }
        for (int x:nums){
            if(count.get(x)==0){
                continue;
            }else if(tail.getOrDefault(x,0)>0){//如果以x-1结尾的尾数元素存在，则更新其中一个不为尾数，+1为尾数
                        tail.put(x,tail.get(x)-1);
                        tail.put(x+1,tail.getOrDefault(x+1,0)+1);
            }else if(count.getOrDefault(x+1,0)>0&&count.getOrDefault(x+2,0)>0){//当前元素无法接上
                tail.put(x+3,tail.getOrDefault(x+3,0)+1);
                count.put(x+2,tail.getOrDefault(x+2,0)-1);
                count.put(x+1,tail.getOrDefault(x+1,0)-1);
            }else{
                return false;
            }
            count.put(x,count.getOrDefault(x,0)-1);
        }
        return true;
    }
}
