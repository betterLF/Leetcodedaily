package String;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/9-9:05
 */
public class Solution1713ms {
    /*

哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，
不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
注意：本题相对原题稍作改动，只需返回未识别的字符数
     */
    //超时间限制
//    public int ans;
//    public int respace(String[] dictionary, String sentence) {
//            ArrayList<Integer> lens=new ArrayList<>();
//            ans=Integer.MAX_VALUE;
//            HashSet<String> set=new HashSet<>();
//        for (int i = 0; i <dictionary.length ; i++) {
//            int len=dictionary[i].length();
//            set.add(dictionary[i]);
//            if(!lens.contains(len)){
//                lens.add(len);
//            }
//        }
//        Collections.sort(lens);
//        dfs(lens,0,0,set,sentence);
//        return ans;
//
//    }
//    private  void dfs(ArrayList<Integer> lens,int start,int unamedLen,HashSet<String> set,String sentence){
//        if(start==sentence.length()){//最后一个字符刚好识别
//            ans=Math.min(ans,unamedLen);
//            return;
//        }
//        if(unamedLen>=ans){//剪枝
//            return;
//        }
//        if(start+lens.get(0)>sentence.length()){//如果后面无法拼成一个单词
//            unamedLen+=sentence.length()-start;
//            ans=Math.min(ans,unamedLen);
//            return;
//        }
//          boolean flag=false;
//        for (int i = start; i <sentence.length(); i++) {
//            if(i-start+unamedLen>=ans){
//                return;
//            }
//            for (int j = 0; j <lens.size() ; j++) {
//                int len=lens.get(i);
//                if(i+len>sentence.length()){
//                    break;
//                }
//                String temp=sentence.substring(i,i+len);
//                if(set.contains(temp)){
//                    flag=true;//说明从当前位置开始后面有单词
//                    System.out.println(temp);
//                    unamedLen+=i-start;
//                    dfs(lens,i+len,unamedLen,set,sentence);
//                    unamedLen-=i-start;//恢复
//                }
//            }
//        }
//        if(flag==false){
//            unamedLen+=sentence.length()-start;
//            ans=Math.min(ans,unamedLen);
//            unamedLen-=sentence.length()-start;
//        }
//    }
//        static final long P = Integer.MAX_VALUE;
//        static final long BASE = 41;
//
//        public int respace(String[] dictionary, String sentence) {
//            Set<Long> hashValues = new HashSet<Long>();
//            for (String word : dictionary) {
//                hashValues.add(getHash(word));
//            }
//
//            int[] f = new int[sentence.length() + 1];
//            Arrays.fill(f, sentence.length());
//
//            f[0] = 0;
//            for (int i = 1; i <= sentence.length(); ++i) {
//                f[i] = f[i - 1] + 1;
//                long hashValue = 0;
//                for (int j = i; j >= 1; --j) {
//                    int t = sentence.charAt(j - 1) - 'a' + 1;
//                    hashValue = (hashValue * BASE + t) % P;
//                    if (hashValues.contains(hashValue)) {
//                        f[i] = Math.min(f[i], f[j - 1]);
//                    }
//                }
//            }
//
//            return f[sentence.length()];
//        }
//
//        public long getHash(String s) {
//            long hashValue = 0;
//            for (int i = s.length() - 1; i >= 0; --i) {
//                hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
//            }
//            return hashValue;
//        }
//    }
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {//将单词插入字典树中
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;//i处未标识的初始化为前一处未标识的+1
            Trie curPos = root;
            for (int j = i-1; j >= 0; --j) {
                int t = sentence.charAt(j) - 'a';//得到当前位置的下标处值
                if (curPos.next[t] == null) {//如果字典树中没有以该点为结尾的，直接退出，其结果就是dp[i-1]+1
                    break;
                } else if (curPos.next[t].isEnd) {//如果字典树中有以该节点为结尾的
                    dp[i] = Math.min(dp[i], dp[j]);//其值为前j个结点的结果(即j+1->i-1为一个单词)
                }
                if (dp[i] == 0) {//如果此时dp[i]==0,就已经达到了可能的最小值，不用继续
                    break;
                }
                curPos = curPos.next[t];//查看下一个点是否满足
            }
        }
        return dp[n];
    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }
}
