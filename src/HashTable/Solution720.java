package HashTable;

/**
 * @authtor liFei
 * @date 2020/9/1-10:21
 */
public class Solution720 {
    /*
    给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
    该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
若无答案，则返回空字符串。
     */
//    public String longestWord(String[] words) {
//        Arrays.sort(words);
//        HashSet<String> set=new HashSet<>();
//        set.add("");
//        int i=0;
//        String ans="";
//        while (i<words.length){
//          if(words[i].length()==1||set.contains(words[i].substring(0,words[i].length()-1))){
//              set.add(words[i]);
//              ans=ans.length()<words[i].length()?words[i]:ans;
//          }
//          i++;
//        }
//        return ans;
//    }
    public String longestWord(String[] words) {

        TrieNode root = new TrieNode(true);
        for(String word : words){
            addToTrieTree(root,word);
        }

        String[] candidates = new String[30];
        char[] seed = new char[30];

        dfs(root, 0, candidates, seed);

        for(int i = 29; i >= 0; i--){
            if(candidates[i] != null){
                return candidates[i];
            }
        }
        return "";
    }

    private void dfs(TrieNode node, int level, String[] candidates, char[] seed){
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null && node.children[i].isLeaf){
                seed[level] = (char)(i + 'a');
                if(candidates[level] == null){
                    candidates[level] = new String(seed, 0, level+1);
                }
                dfs(node.children[i], level+1, candidates, seed);
            }
        }
    }

    private void addToTrieTree(TrieNode root, String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int offset = c - 'a';
            if (node.children[offset] == null){
                node.children[offset] = new TrieNode(false);
            }
            node = node.children[offset];
        }
        node.isLeaf = true;
    }

    private static class TrieNode {
        private boolean isLeaf;
        private final TrieNode[] children;

        private TrieNode (boolean isLeaf){
            this.isLeaf = isLeaf;
            children = new TrieNode[26];
        }
    }
}
