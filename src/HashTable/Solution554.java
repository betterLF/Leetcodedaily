package HashTable;

import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/20-6:29
 */
public class Solution554 {
    /*
    你的面前有一堵矩形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (List<Integer> cur:wall){
            int curSum=0;
            for (int i = 0; i <cur.size()-1 ; i++) {
                curSum+=cur.get(i);
                map.put(curSum,map.getOrDefault(curSum,0)+1);
            }
        }
        int max=0;
        for (Integer key:map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
            }
        }
        return wall.size()-max;
    }
}
