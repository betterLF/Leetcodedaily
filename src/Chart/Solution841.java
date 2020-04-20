package Chart;

import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/20-6:57
 */
public class Solution841 {
    /*
    有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
其中 N = rooms.length。
钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
最初，除 0 号房间外的其余所有房间都被锁住。
你可以自由地在房间之间来回走动。
如果能进入每个房间返回 true，否则返回 false。
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size()==1){
            return true;
        }
         boolean res[]=new boolean[rooms.size()];//初始化为false，表示为访问过
         res[0]=true;
         return  BFS(rooms,0,res);

    }
    private boolean isAllVisited(boolean res[]){
        for (int i = 0; i <res.length ; i++) {
            if(res[i]==false){
                return false;
            }
        }
        return true;
    }
    private boolean BFS(List<List<Integer>> rooms,int index,boolean res[]){
        List<Integer> room=rooms.get(index);
        for (int i = 0; i <room.size() ; i++) {
            if(res[room.get(i)]!=true){
                res[room.get(i)]=true;
                 BFS(rooms,room.get(i),res);
                if(isAllVisited(res)){
                    return true;
                }
            }
            }
        return false;
    }
}
