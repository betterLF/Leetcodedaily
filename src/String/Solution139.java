package String;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/16-8:51
 */
public class Solution139 {
    /*
    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
     */
    //回溯，超限制
    boolean flag;

    public boolean wordBreak(String s, List<String> wordDict) {
        flag = false;
        back(s, 0, wordDict);
        return flag;
    }

    private void back(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            flag = true;
            return;
        }
        if (flag == true) {
            return;
        }
        for (int i = s.length(); i >= start + 1; i--) {
            if (wordDict.contains(s.substring(start, i))) {
                back(s, i, wordDict);
            }
            if (flag == true) {
                return;
            }
        }
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> ss = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                //存在一个j,使得方程成立即可
                if (dp[j] && ss.contains(s.substring(j, i))) {//dp[j]代表前j-1个子元素可以有单词构成，
                    // ss.contains(s.substring(j,i)代表该元素在单词表中
                    dp[i] = true;//则该位置前的元素都能由单词表构成
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {//取出每个当前可拼接的字符末尾的下一个元素，如果它未被访问过，就进行访问
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {//以该结点出发的所有可行子串的末尾加入队列中
                        queue.add(end);
                        if (end == s.length()) {//如果刚好到达末尾，加入结果集
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
    public boolean wordBreak4(String s, List<String> wordDict) {
        int m = s.length();
        if (s.length() == 0) return false;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String w: wordDict){
                int len = w.length();
                if(i >= len && f[i - len] == true&& s.substring(i - len, i).equals(w)){//如果当前单词表中该元素在前i个元素里就返回true
                    f[i] = true;
                    break;
                }
            }

        }
        return f[m];
    }

}