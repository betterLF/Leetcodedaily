package HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/4/29-7:21
 */
public class Solution884 {
    /*
    给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
返回所有不常用单词的列表。
您可以按任何顺序返回列表。
     */
    public String[] uncommonFromSentences(String A, String B) {
        String a[]=A.split(" ");
        String b[]=B.split(" ");
        HashMap<String,Integer> ans=new HashMap<>();
        for (int i=0;i<a.length;i++){
            ans.put(a[i],ans.getOrDefault(a[i],0)+1);
        }
        for (int i=0;i<b.length;i++){
            ans.put(b[i],ans.getOrDefault(b[i],0)+1);
        }
        String res[]=new String[200];
        int count=0;
        for (String key:ans.keySet()){
            if(ans.get(key)==1){
            res[count]=key;
            count++;
            }
        }
        return Arrays.copyOf(res,count);
    }
}
