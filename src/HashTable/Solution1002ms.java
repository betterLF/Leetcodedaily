package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/23-13:46
 */
public class Solution1002ms {
    /*

编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
注意：本题相对原题稍作修改
     */
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        int index=0;
        for (int i = 0; i <strs.length; i++) {
            String cur=toString(strs[i]);
            if(!map.containsKey(cur)){
                map.put(cur,index);
                ArrayList<String> n=new ArrayList<>();
                n.add(strs[i]);
                ans.add(n);
                index++;
            }else{
                ans.get(map.get(cur)).add(strs[i]);
            }
        }
        return ans;
    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for (int i = 0; i <strs.length; i++) {
            String cur=toString(strs[i]);
            if(!map.containsKey(cur)){
                ArrayList<String> n=new ArrayList<>();
                n.add(strs[i]);
                map.put(cur,n);
            }else{
               map.get(cur).add(strs[i]);
            }
        }
        for(String cur:map.keySet()){
            ans.add(map.get(cur));
        }
        return ans;
    }
    private String toString(String cur){
        int count[]=new int[26];
        for (char c:cur.toCharArray()){
            count[c-'a']++;
        }
        return Arrays.toString(count);
    }
    private String toString2(String cur){//比1的计数排序更快
             char c[]=cur.toCharArray();
             Arrays.sort(c);
        return Arrays.toString(c);
    }
}
