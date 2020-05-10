package Array;

/**
 * @authtor liFei
 * @date 2020/5/8-17:31
 */
public class Solution62 {
    /*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
     */
    private int count = 0;
    private int endR = 0;
    private int endC = 0;

    public int uniquePaths(int m, int n) {//递归超时
        endR = m - 1;
        endC = n - 1;
        getPath(0, 0);
        return count;

    }

    private void getPath(int startR, int startC) {
        if (startR == endR && startC == endC) {
            count++;
            return;
        }
        if (startR == endR) {
            getPath(startR, startC + 1);
            return;
        }
        if (startC == endC) {
            getPath(startR + 1, startC);
            return;
        }
        getPath(startR + 1, startC);
        getPath(startR, startC + 1);
    }

    public int uniquePaths2(int m, int n) {
       long choice = 1;
       int max=m>n?m:n;
       int min=m<n?m:n;
        for (int i = max; i <= m + n - 2; i++) {
            choice *= i;
        }
        long cf2 = 1;
        for (int i = 1; i <= min- 1; i++) {
            cf2 *= i;
        }
        return (int)(choice  / cf2);
    }
}
