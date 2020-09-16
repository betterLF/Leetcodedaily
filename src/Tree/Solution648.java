package Tree;

import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/13-17:18
 */
public class Solution648 {
    /*

在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成
另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
     */
    public class wordTree{
        public wordTree[] children;
        String word;
        public wordTree(){
            children=new wordTree[26];
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        wordTree word=new wordTree();
        for (int i = 0; i <dictionary.size() ; i++) {
            wordTree c=word;
            for (char cur:dictionary.get(i).toCharArray()) {
                if(c.children[cur-'a']==null){
                    c.children[cur-'a']=new wordTree();
                }
                c=c.children[cur-'a'];
            }
            c.word=dictionary.get(i);
        }
        StringBuilder ans=new StringBuilder();
        for (String cur:sentence.split(" ")){
            if(cur.equals(" ")){
                continue;
            }else{
                wordTree cc=word;
                for (char c:cur.toCharArray()){
                    if(cc.children[c-'a']==null||cc.word!=null){
                        break;
                    }else{
                        cc=cc.children[c-'a'];
                    }
                }
                String s=cc.word==null?cur:cc.word;
                ans.append(s).append(" ");
            }
        }
        return ans.deleteCharAt(ans.length()-1).toString();
    }
}
