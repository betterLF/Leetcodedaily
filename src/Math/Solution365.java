package Math;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/10-7:11
 */
public class Solution365 {
    /*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
     */
        public boolean canMeasureWater(int x, int y, int z) {
            Stack<int[]> stack = new Stack<>();  // 存储所有可能的状态
            Set<Map.Entry<Integer, Integer>> seenSet = new HashSet<>();  // 存储处理过的状态
            stack.push(new int[]{0, 0});
            while (!stack.isEmpty()) {
                int[] arr = stack.pop();
                if ((arr[0] == z) || (arr[1] == z) || (arr[0] + arr[1] == z)) return true;
                Map.Entry<Integer, Integer> currEntry = new AbstractMap.SimpleEntry<>(arr[0], arr[1]);
                if (seenSet.contains(currEntry)) continue;  // 之前处理过这个状态，跳过
                seenSet.add(currEntry);  // 把处理过的这个状态加入到已经处理过的集合内
                stack.add(new int[]{0, arr[1]});  // 倒空x
                stack.add(new int[]{arr[0], 0});  // 倒空y
                stack.add(new int[]{x, arr[1]});  // 加满x
                stack.add(new int[]{arr[0], y});   // 加满y
                // x往y中倒水
                if (arr[0] + arr[1] < y) stack.add(new int[]{0, arr[0] + arr[1]});  // 如果不会倒满，x空，y是当前两桶水之和
                else stack.add(new int[]{arr[0] + arr[1] - y, y});  // 如果会倒满，x中会有剩余，y满
                // y往x中倒水
                if (arr[0] + arr[1] < x) stack.add(new int[]{arr[0] + arr[1], 0});  // 如果不会倒满，y空，x是当前两桶水之和
                else stack.add(new int[]{x, arr[0] + arr[1] - x});  // 如果会倒满，y中会有剩余，x满
            }
            return false;  // 没有达到z，桟已空，返回false不可能
        }
    public boolean canMeasureWater2(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }

}

