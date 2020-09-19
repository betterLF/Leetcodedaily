package Design;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/9/16-8:04
 */
public class Solution676 {
    /*
    实现一个带有buildDict, 以及 search方法的魔法字典。
对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
     */
    class MagicDictionary {
        HashMap<Integer, ArrayList<String>> map;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            map=new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
                 map.clear();
            for (int i = 0; i <dictionary.length ; i++) {
                int len=dictionary[i].length();
                if(map.containsKey(len)){
                    map.get(len).add(dictionary[i]);
                }else{
                    ArrayList<String> cur=new ArrayList<>();
                    cur.add(dictionary[i]);
                    map.put(len,cur);
                }
            }
        }

        public boolean search(String searchWord) {
           int len=searchWord.length();
           if(!map.containsKey(len)){
               return false;
           }else{
               ArrayList<String> list = map.get(len);
               for (int i = 0; i <list.size() ; i++) {
                   if(getDif(searchWord,list.get(i))==1){
                       return true;
                   }
               }
               return false;
           }
        }
        private int getDif(String target,String cur){
            int ans=0;
            for (int i = 0; i <target.length() ; i++) {
                if(target.charAt(i)!=cur.charAt(i)){
                    ans++;
                }
            }
            return ans;
        }
    }
}
