package BinarySearch;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/9/28-12:08
 */
public class Solution792 {
    /*
    给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
     */
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<String>());
        }
        for (String w : words) {
            map.get(w.charAt(0)).addLast(w);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> deque = map.get(c);
            int size = deque.size();
            for (int i = 0; i < size; i ++) {
                String w = deque.removeFirst();
                if (w.length() == 1) {
                    count ++;
                } else {
                    map.get(w.charAt(1)).addLast(w.substring(1));
                }
            }
        }
        return count;
    }
}
