package Tree;

/**
 * @authtor liFei
 * @date 2020/6/27-6:27
 */
public class Solution211 {
    /*
    设计一个支持以下两种操作的数据结构：
void addWord(word)
bool search(word)
search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
     */
    class WordDictionary {
        private WordDictionary[] next;
        private boolean is_Word;
        public WordDictionary() {
            next=new WordDictionary[26];
            is_Word=false;
        }

        public void addWord(String word) {
            WordDictionary root=this;
            char []cur=word.toCharArray();
            for (int i = 0; i <cur.length ; i++) {
                if(root.next[cur[i]-'a']==null){
                    root.next[cur[i]-'a']=new WordDictionary();
                }
                root=root.next[cur[i]-'a'];
            }
            root.is_Word=true;//代表其是单词

        }

        public boolean search(String word) {
         return search(word,0,this);
        }
        public boolean search(String word,int count,WordDictionary root){
            if(count==word.length()){
                if(root.is_Word) {
                    return true;
                }else{
                    return false;
                }
            }
            char c=word.charAt(count);
            if(c=='.'){
                for (int i = 0; i <26 ; i++) {
                    if(root.next[i]!=null){
                        if(search(word,count+1,root.next[i])){
                            return true;
                        };
                    }
                }
                return false;
            }else{
                if(root.next[c-'a']==null){
                    return false;
                }else{
                    if(search(word,count+1,root.next[c-'a'])){
                        return true;
                    }
                }
            }
            return false;


        }
    }
    }

