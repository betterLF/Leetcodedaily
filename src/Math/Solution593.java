package Math;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/8/22-7:28
 */
public class Solution593 {
    /*
    给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
一个点的坐标（x，y）由一个有两个整数的整数数组表示。
     */
    public class Solution {
        public double dist(int[] p1, int[] p2) {
            return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
        }
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[][] p={p1,p2,p3,p4};
            Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
            return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0])   && dist(p[0],p[3])==dist(p[1],p[2]);
        }
    }
}
