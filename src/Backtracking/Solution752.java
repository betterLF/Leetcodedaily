package Backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/9/24-15:51
 */
public class Solution752 {
    /*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：
例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     */
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> cannot=new HashSet<>();
        for (String cur:deadends){
            cannot.add(cur);
        }
        Queue<String> queue=new LinkedList<>();
        queue.add("0000");
        queue.offer(null);
        set.add("0000");
        int depth=0;
        while (!queue.isEmpty()){
            String poll=queue.poll();
            if(poll==null){
                depth++;
                if(queue.peek()!=null){
                    queue.offer(null);
                }
            }else if(poll.equals(target)){
                return depth;
            }else if(!cannot.contains(poll)){
                for (int i = 0; i <4 ; i++) {
                    for (int j = -1; j <=1 ; j+=2) {
                        int y = ((poll.charAt(i) - '0') + j + 10) % 10;
                        String cur=poll.substring(0,i)+(""+y)+poll.substring(i+1);
                        if(!set.contains(cur)){
                            set.add(cur);
                            queue.add(cur);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
