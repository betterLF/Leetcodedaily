package String;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/14-9:32
 */
public class Solution127 {
    /*
    给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     */
    //深度优先搜索超限制
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
       boolean []isVisited = new boolean[wordList.size()];
        Queue<String> queue=new ArrayDeque<>();
        queue.add(beginWord);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), 0);
        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            int count=1;
            if(temp!=beginWord){
                count=map.get(temp);
            }
            for (int i = 0; i < wordList.size(); i++) {
                String s=wordList.get(i);
                if ( isVisited[i] == false&&isAccess(temp, s)) {
                    map.put(s,count+1);
                    isVisited[i] = true;//该位置已经访问过
                    queue.add(s);//将该结点加入队列
                    if(s.equals(endWord)){
                        break;
                    }
                }
            }
        }
        return map.get(endWord);
    }
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        boolean []isVisited = new boolean[wordList.size()];
        Queue<String> queue=new ArrayDeque<>();
        queue.add(beginWord);
        int depth=2;
        int count=1;
        int curCount=0;
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            for (int i = 0; i < wordList.size(); i++) {
                String s=wordList.get(i);
                if ( isVisited[i] == false&&isAccess(temp, s)) {
                    isVisited[i] = true;//该位置已经访问过
                    queue.add(s);//将该结点加入队列
                    if(s.equals(endWord)){
                      return depth;
                    }
                    curCount++;
                }
            }
            count--;
            if(count==0){
                depth++;
                count=curCount;
                curCount=0;
            }
        }
        return 0;
    }
    private boolean isAccess(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
