package Greedy;

import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/5/1-6:50
 */
public class Solution1029 {
    /*
    公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
     */
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        PriorityQueue<int[]> cur = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
        int countA = len / 2;
        int countB = len / 2;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            int a[] = {i, Math.abs(costs[i][0] - costs[i][1])};
            cur.add(a);
        }
        while (!cur.isEmpty()) {
            int x = cur.poll()[0];
            if (countA != 0 && countB != 0) {
                if (costs[x][0] > costs[x][1]) {
                    countB--;
                    sum += costs[x][1];
                } else {
                    countA--;
                    sum += costs[x][0];
                }
            } else if (countA == 0) {
                sum += costs[x][1];
            } else {
                sum += costs[x][0];
            }
        }
        return sum;
    }
}
