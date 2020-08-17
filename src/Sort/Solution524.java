package Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/15-7:17
 */
public class Solution524 {
    /*
    给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
    如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     */
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length()==o1.length()){
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
        });
        for (int i = 0; i <d.size() ; i++) {
            if(isRight(s,d.get(i))){
                return d.get(i);
            }
        }
        return "";
    }
//    private boolean isRight(String target,String cur){
//        int i=0;
//        int j=0;
//        for (; i<target.length()&&j<cur.length() ; i++) {
//            if(target.charAt(i)==cur.charAt(j)){
//                j++;
//            }
//        }
//        return j==cur.length();
//    }
    public String findLongestWord2(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {//不进行排序
            if (isRight(s, str)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }
    public boolean isRight(String s, String ele){
        int index = -1;
        for (int i = 0; i < ele.length(); i++) {
            index = s.indexOf(ele.charAt(i), index + 1);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}
