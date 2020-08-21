package Sort;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/8/18-7:22
 */
public class Solution539 {
    /*
    给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
     */
    public int findMinDifference(List<String> timePoints) {
        Queue<Integer> queue=new PriorityQueue<>();
        for (int i = 0; i <timePoints.size() ; i++) {
            String cur=timePoints.get(i);
            int curAns=((cur.charAt(0)-'0')*10+(cur.charAt(1)-'0'))*60+(cur.charAt(3)-'0')*10+(cur.charAt(4)-'0');
            queue.add(curAns);
            queue.add(curAns+24*60);
        }
        int ans=Integer.MAX_VALUE;
        int count=0;
        while (queue.peek()<24*60){
            int poll=queue.poll();
            ans=Math.min(queue.peek()-poll,ans);
        }
        return ans;
    }
    public int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] minute = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++)
            minute[i] = Integer.valueOf(timePoints.get(i).substring(0, 2)) * 60
                    + Integer.valueOf(timePoints.get(i).substring(3, 5));
        Arrays.sort(minute);
        for (int i = 0; i < minute.length - 1; i++)
            min = Math.min(min, minute[i + 1] - minute[i]);
        return Math.min(min, 1440 - minute[minute.length - 1] + minute[0]);
    }
}

