package Tree;

import java.util.TreeMap;

/**
 * @authtor liFei
 * @date 2020/9/22-17:27
 */
public class Solution731 {
    /*

实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，
这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     */
    class MyCalendarTwo {
           TreeMap<Integer,Integer> map;
        public MyCalendarTwo() {
            map=new TreeMap<>();
        }

        public boolean book(int start, int end) {
                   map.put(start,map.getOrDefault(start,0)+1);
                   map.put(end,map.getOrDefault(end,0)-1);
            int active = 0;
            for (int d: map.values()) {
                active += d;
                if (active >= 3) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    if (map.get(start) == 0)
                        map.remove(start);
                    return false;
                }
            }
            return true;
        }
        }
}
