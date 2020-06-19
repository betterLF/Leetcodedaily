package Array;

/**
 * @authtor liFei
 * @date 2020/6/15-8:11
 */
public class Solution134 {
    /*
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
说明: 
如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
     */
    //178ms
    boolean flag;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        flag = false;
        int curGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas = gas[i] - cost[i];
            if (curGas < 0) {
                continue;
            } else {
                if (i == gas.length - 1) {
                    isAccessible(gas, cost, i, 0, curGas);
                } else {
                    isAccessible(gas, cost, i, i + 1, curGas);
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void isAccessible(int[] gas, int[] cost, int start, int nowIndex, int curGas) {
        if (nowIndex == start) {
            flag = true;
            return;
        }
        curGas += gas[nowIndex] - cost[nowIndex];
        if (curGas < 0) {//如果右不够，直接返回
            return;
        } else {
            if (nowIndex == gas.length - 1) {
                isAccessible(gas, cost, start, 0, curGas);
            } else {
                isAccessible(gas, cost, start, nowIndex + 1, curGas);
            }
        }
    }
//33ms
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas = gas[i] - cost[i];
            if(curGas<0){//如果该点不能出发，找下一个点
                continue;
            }
            int start=i;
            int j=i==gas.length-1?0:i+1;
            while (j!=i){
                curGas+=gas[j]-cost[j];
                if(curGas<0){
                    break;
                }else{
                    j=j==gas.length-1?0:j+1;
                }
            }
              if(j==i){
                  return i;
              }
        }
        return -1;
    }
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;//如果总加油量小于总花费量，肯定不能到达，直接返回-1
    }

}