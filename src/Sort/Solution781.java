package Sort;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/9/27-10:33
 */
public class Solution781 {
    /*
    森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
返回森林中兔子的最少数量。
     */
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int cur:answers){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int ans=0;
        for (Integer key:map.keySet()){
            int count=map.get(key);
            ans+=count%(key+1)==0?count:(count/(key+1)+1)*(key+1);
        }
        return ans;
    }
}
