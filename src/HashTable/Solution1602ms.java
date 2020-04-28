package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/4/27-8:31
 */
public class Solution1602ms {
    /*
设计一个方法，找出任意指定单词在一本书中的出现频率。
你的实现应该支持如下操作：
WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
get(word)查询指定单词在数中出现的频率
     */
    class WordsFrequency {
        HashMap<String, Integer> ans = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (int i = 0; i < book.length; i++) {
                ans.put(book[i], ans.getOrDefault(book[i], 0) + 1);
            }
        }

        public int get(String word) {
//            if(ans.containsKey(word)){
//                return ans.get(word);
//            }
//           return 0;
//        }
            return ans.getOrDefault(word, 0);
        }
    }
}
