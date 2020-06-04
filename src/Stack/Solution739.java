package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/1-17:00
 */
public class Solution739 {
    /*
    根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.size() == 0) {//如果栈为空，当前温度下标加入栈中
                stack.push(i);
            } else {
                while ((!stack.isEmpty()) && T[i] > T[stack.peek()]) {//只要栈不为空且当前温度大于当前栈顶温度
                    int cur = stack.pop();//出栈
                    ans[cur] = i - cur;//加入结果集
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {//可以不用，因为数组默认元素值为0
            int cur = stack.pop();
            ans[cur] = 0;
        }
        return ans;

    }

    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] values = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {//如果当前元素小于此元素，计算出结果直接返回
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {//如果此元素的值为0，说明T[j]后面没有比它大的了，不用在找下去了
                    values[i] = 0;
                    break;

                }
                j = j + values[j];//找到比j高的温度继续进行比较
            }
        }
        return values;
    }
}