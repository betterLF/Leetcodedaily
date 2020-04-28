package HashTable;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/27-8:54
 */
public class Solution500 {
    /*
    给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
     */
    public static void main(String[] args) {
        String words[]={"Hello","Alaska","Dad","Peace"};
        findWords(words);
    }
    static List<List<Character>> ans=new ArrayList<>();
    static {
        List<Character> one = new ArrayList<>(Arrays.asList('Q', 'q', 'W', 'w', 'E', 'e', 'R', 'r', 'T', 't', 'Y', 'y', 'U', 'u', 'I', 'i', 'O', 'o', 'P', 'p'));
        List<Character> two = new ArrayList<>(Arrays.asList('A', 'a', 'S', 's', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h', 'J', 'j', 'K', 'k', 'L', 'l'));
        List<Character> three = new ArrayList<>(Arrays.asList('Z', 'z', 'X', 'x', 'C', 'c', 'V', 'v', 'B', 'b', 'N', 'n', 'M', 'm'));
        ans.add(one);
        ans.add(two);
        ans.add(three);
    }
    public static String[] findWords(String[] words) {
        ArrayList<String> res=new ArrayList<>();
        for (int i=0;i<words.length;i++){
//            HashSet<Character> cur=new HashSet<>();
//            for (char c:words[i].toCharArray()){
//                cur.add(c);
//            }
//            for (int j=0;j<3;j++){
//                if(ans.get(j).containsAll(cur)){
//                    res.add(words[i]);
//                    break;
//                }
//            }
            char c[]=words[i].toCharArray();
            for (int j=0;j<3;j++){
                int judge=0;
                if(ans.get(j).contains(c[0])){
                    int len=c.length;
                    for (int k=1;k<len;k++){
                        if(!ans.get(j).contains(c[k])){
                            judge=1;
                            break;
                        }
                    }
                    if(judge==0) {
                        res.add(words[i]);
                    }
                    break;
                }
            }
        }
       String last[]=new String[res.size()];
        for (int i = 0; i <last.length ; i++) {
            last[i]=res.get(i);
        }
        return last;
    }
    public String[] findWords2(String[] words) {
        if(words==null||words.length==0) return new String[0];
        //用长度为26的数组标识每个字母所在的行号
        int[] map = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<String>();
        for(String word:words){
            String tempWord = word.toUpperCase();//全转成大写字母
            int temp = map[tempWord.charAt(0)-65];
            boolean flag = true;
            //通过与首字母比较行号确定是否在同一行
            for(int i=1;i<tempWord.length();i++){
                if(temp != map[tempWord.charAt(i)-65]){
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
}
