package HashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/4/28-7:54
 */
public class Solution1207 {
    /*
    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> ans=new HashSet<>();
        HashMap<Integer,Integer> cur=new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            cur.put(arr[i],cur.getOrDefault(arr[i],1)+1);
        }
        int count=0;
        for (Integer key:cur.keySet()){
            ans.add(cur.get(key));
            count++;
        }
        if(count==ans.size()){
            return true;
        }
        return false;
    }
}
