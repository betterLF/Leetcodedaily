package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/9/5-12:12
 */
public class Solution819 {
    /*
    给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
题目保证至少有一个词不在禁用列表中，而且答案唯一。
禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
     */
//    public String mostCommonWord(String paragraph, String[] banned) {
//        String[] words = paragraph.split("[!?',;. ]");
//        HashMap<String, Integer> map = new HashMap<>();
//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < banned.length; i++) {
//            set.add(banned[i].toLowerCase());
//        }
//        for (String cur : words) {
//            if(cur.equals("")){
//                continue;
//            }
//            map.put(cur.toLowerCase(), map.getOrDefault(cur.toLowerCase(), 0) + 1);
//        }
//        int curAns = 0;
//        String cur = "";
//        for (String c : map.keySet()) {
//            if (map.get(c) > curAns && !set.contains(c)) {
//                cur = c;
//                curAns = map.get(c);
//            }
//        }
//        return cur.toLowerCase();
//    }
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        int prv = 0, max = Integer.MIN_VALUE;
        String result = "";
        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c >= 'a' && c <= 'z'){

            }else if(c >= 'A' && c <= 'Z'){
                chars[i] = (char)(c + 32);
            }else{
                if(i - prv != 0){
                    String str = new String(chars, prv, i - prv);
                    if(!set.contains(str)){
                        int count = map.getOrDefault(str, 0) + 1;
                        map.put(str, count);
                        if(count > max){
                            result = str;
                            max = count;
                        }
                    }
                }
                prv = i + 1;
            }
        }
        if(prv != chars.length - 1){
            String str = new String(chars, prv, chars.length - prv);
            if(!set.contains(str)){
                int count = map.getOrDefault(str, 0) + 1;
                map.put(str, count);
                if(count > max){
                    result = str;
                    max = count;
                }
            }
        }
        return result;
    }

}
