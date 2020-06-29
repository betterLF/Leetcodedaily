package Tree;

/**
 * @authtor liFei
 * @date 2020/6/26-7:33
 */
public class Solution208 {
    /*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
     */
    public class Trie {
        private boolean is_string=false;
        private Trie next[]=new Trie[26];

        public Trie(){}

        public void insert(String word){//插入单词
            Trie root=this;
            char w[]=word.toCharArray();
            for(int i=0;i<w.length;++i){
                if(root.next[w[i]-'a']==null) {//如果当前结点的下一个w[i]的域为空
                    root.next[w[i] - 'a'] = new Trie();//创建该域
                }
                root=root.next[w[i]-'a'];//将该结点移动到下一个
            }
            root.is_string=true;//表示当前点为一个单词
        }

        public boolean search(String word){//查找单词
            Trie root=this;
            char w[]=word.toCharArray();
            for(int i=0;i<w.length;++i){
                if(root.next[w[i]-'a']==null)return false;//如果当前结点的下一个域中没有该字母，返回false
                root=root.next[w[i]-'a'];//否则结点后移
            }
            return root.is_string;//判断该结点是否为true
        }

        public boolean startsWith(String prefix){//查找前缀
            Trie root=this;
            char p[]=prefix.toCharArray();
            for(int i=0;i<p.length;++i){
                if(root.next[p[i]-'a']==null)return false;
                root=root.next[p[i]-'a'];
            }
            return true;
        }
    }
}