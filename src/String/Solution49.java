package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/19-6:49
 */

public class Solution49 {
    /*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。*/
    public static void main(String[] args) {
         String c[]={"eat", "tea", "tan", "ate", "nat", "bat"};
         groupAnagrams(c);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer,List<String>> cur=new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
          int temp = getMul(strs[i].toCharArray());
            if (cur.containsKey(temp)) {
                cur.get(temp).add(strs[i]);
            } else {
                ArrayList<String> c=new ArrayList<>();
                c.add(strs[i]);
                cur.put(temp, c);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for (Integer key:cur.keySet()){
            ans.add(cur.get(key));
        }
        return ans;
    }
   public static int[] number={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    public static  int getMul(char []cur){
        int mul=1;
        for (int i = 0; i <cur.length ; i++) {
            mul*=number[cur[i]-97];
        }
        return mul;
    }
}
