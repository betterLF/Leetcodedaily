package String;

import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/9/10-8:47
 */
public class Solution636 {
    /*
    给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
日志是具有以下格式的字符串：function_id：start_or_end：timestamp。
例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。
你需要根据函数的 Id 有序地返回每个函数的独占时间。
     */
    public int[] exclusiveTime(int n, List< String > logs) {
        Stack< Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;//得到当前该任务和下一个任务之前的独立时间
                stack.push(Integer.parseInt(s[0]));//将该结点加入栈中
                prev = Integer.parseInt(s[2]);//更新前一个位置为加入栈的元素的开始时间
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;//该任务的结束时间加到结果集中
                stack.pop();//弹出该节点
                prev = Integer.parseInt(s[2]) + 1;//更新减去的元素为当前元素结束+1
            }
            i++;
        }
        return res;
    }

}
