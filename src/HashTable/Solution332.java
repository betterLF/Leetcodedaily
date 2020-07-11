package HashTable;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/7-19:04
 */
public class Solution332 {
    /*
    给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
    所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
说明:
如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
     */
    public LinkedList<String> ans;
    public int target;
    public List<String> findItinerary(List<List<String>> tickets) {
           ans=new LinkedList<>();
           target=tickets.size()+1;
           HashMap<String,LinkedList<String>> map=new HashMap<>();
        for (int i = 0; i <tickets.size() ; i++) {
            String cur=tickets.get(i).get(0);
            String cur2=tickets.get(i).get(1);
            if(map.containsKey(cur)){
                map.get(cur).add(cur2);
            }else{
                LinkedList<String> list=new LinkedList<>();
                list.add(cur2);
                map.put(cur,list);
            }
        }
        for (String cur:map.keySet()){
            Collections.sort(map.get(cur));
        }
           ans.add("JFK");
           DFS(map,"JFK");
           return ans;
    }
    private boolean  DFS( HashMap<String,LinkedList<String>> map,String cur){
        if(ans.size()==target){//如果刚好达到有效集合的长度
            return true;
        }
        if(!map.containsKey(cur)){
            return false;
        }
        for (int i = 0; i <map.get(cur).size() ; i++) {
                String cc=map.get(cur).remove(i);//移除自然排序第i个元素
                ans.add(cc);
              if(DFS(map,cc)){
                  return true;
            }else{//则继续遍历，以下一个点为目标点
                    ans.removeLast();//该点出结果集
                    map.get(cur).add(i,cc);//将该点重新加入该结果中
                }
        }
        return false;
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        ans=new LinkedList<>();
        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
        for (int i = 0; i <tickets.size() ; i++) {
            String cur=tickets.get(i).get(0);
            String cur2=tickets.get(i).get(1);
            if(map.containsKey(cur)){
                map.get(cur).add(cur2);
            }else{
                PriorityQueue<String> list=new PriorityQueue<>();
                list.add(cur2);
                map.put(cur,list);
            }
        }
        DFS2(map,"JFK");
        return ans;
    }
    private void DFS2( HashMap<String,PriorityQueue<String>> map,String cur){
         while (map.containsKey(cur)&&map.get(cur).size()!=0){
             DFS2(map,map.get(cur).poll());
         }
        ans.add(0,cur);
}
}
