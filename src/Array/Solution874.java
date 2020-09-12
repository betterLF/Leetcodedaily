package Array;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/9/9-13:03
 */
public class Solution874 {
    /*
    机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
-2：向左转 90 度
-1：向右转 90 度
1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。
第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i <obstacles.length ; i++) {
            set.add(obstacles[i][0]*30000+obstacles[i][1]);
        }
        int ans=0;
        int []row={0,-1,0,1};//东南西北
        int []col={1,0,-1,0};
        int dis=3;
        int curX=0;
        int curY=0;
        for (int i = 0; i <commands.length ; i++) {
            if(commands[i]>=0){
                for (int j = 0; j <commands[i] ; j++) {
                    curX+=col[dis];
                    curY+=row[dis];
                    //System.out.println(curX+","+curY);
                    if(set.contains(curX*30000+curY)){
                        curX-=col[dis];
                        curY-=row[dis];
                        break;
                    }else{
                        ans=Math.max(ans,curX*curX+curY*curY);
                    }
                }
            }else{
                dis=commands[i]==-1?(dis+1)%4:(dis+3)%4;
            }
        }
        return ans;
    }
}
