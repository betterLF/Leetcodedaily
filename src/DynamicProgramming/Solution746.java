package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/9/3-7:21
 */
public class Solution746 {
    /*
    数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶段
     */
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        for (int i = 2; i <cost.length ; i++) {
            cost[i]=Math.min(cost[i-1],cost[i-2])+cost[i];
        }
        return Math.min(cost[len-1],cost[len-2]);
    }
}
