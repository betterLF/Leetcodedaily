package Array;

/**
 * @authtor liFei
 * @date 2020/5/12-7:10
 */
public class Solution1184 {
    /*

环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
环线上的公交车都可以按顺时针和逆时针的方向行驶。
返回乘客从出发点 start 到目的地 destination 之间的最短距离。
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int all=getAllSum(distance);
        int temp=getSum(distance,start,destination);
          return Math.min(temp,all-temp);
    }
    private int getAllSum(int []distance){
        int ans=0;
        for (int cur:distance){
            ans+=cur;
        }
        return ans;
    }
    private int getSum(int []distance,int start,int destination){
        int min=Math.min(start,destination);
        int max=Math.max(start,destination);
        int ans=0;
        for (int i = min; i <max ; i++) {
             ans+=distance[i];
        }
        return ans;
    }
}
