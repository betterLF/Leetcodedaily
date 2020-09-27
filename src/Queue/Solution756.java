package Queue;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/25-8:03
 */
public class Solution756 {
    /*
     */
    boolean flag;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<String>>map=new HashMap<>();
        flag=false;
        for (String cur:allowed){
            String c=cur.substring(0,2);
            if(map.containsKey(c)){
                map.get(c).add(cur.substring(2));
            }else {
                ArrayList<String> list=new ArrayList<>();
                list.add(cur.substring(2));
                map.put(c, list);
            }
        }
        return back(map,new StringBuilder(),bottom,0);
    }
    private boolean back(HashMap<String,List<String>> map, StringBuilder next, String cur, int start){
        if(start==cur.length()-1){
            if(next.length()==1){
                return true;
            }else{
                cur=next.toString();
                start=0;
                return  back(map,new StringBuilder(),cur,0);
            }
        }
        String target=cur.substring(start,start+2);
        if(!map.containsKey(target)){
            return false;
        }else{
            List<String> s = map.get(target);
            for (String c:s){
                next.append(c);
                if(back(map,next,cur,start+1)){
                    return true;
                }else{
                    next.deleteCharAt(next.length()-1);
                }
            }
        }
        return false;
    }
}
