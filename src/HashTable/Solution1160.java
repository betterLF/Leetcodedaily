package HashTable;

import java.util.Arrays;

public class Solution1160 {
    /*
    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
     */
    public int countCharacters(String[] words, String chars) {
        int arr[] = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            arr[chars.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            int arr2[] = Arrays.copyOf(arr, 26);
            int count2 = words[i].length() - 1;
            int flag = 1;
            while (count2 >= 0) {
                if (arr2[words[i].charAt(count2) - 'a'] > 0) {
                    arr2[words[i].charAt(count2) - 'a']--;
                    count2--;
                } else {
                    flag = 0;
                    break;
                }
            }
                if (flag == 1) {
                    count += words[i].length();
            }
        }
        return count;
    }
}
