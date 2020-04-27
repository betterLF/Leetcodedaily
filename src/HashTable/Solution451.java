package HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/10-15:14
 */
public class Solution451 {
    /*
    给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     */
    public static void main(String[] args) {
        String s="tttsfdhgagt";
       System.out.println(frequencySort(s));
//       StringBuilder arr[]=new StringBuilder[2];
//        System.out.println(arr[0]);

}
   public static String frequencySort(String s) {
       StringBuilder cur[]=new StringBuilder[256];//用于存储相同字符串的链接结果
       for(char c:s.toCharArray()){
           if (cur[c] == null) {
               cur[c] =new StringBuilder().append(c);
           } else {
               cur[c].append(""+c);
           }
       }
       //按照字符串的长度进行递减排序
       Comparator<StringBuilder> cc=new Comparator() {
           @Override
           public int compare(Object o1, Object o2) {
               return o2.toString().length()-o1.toString().length();
           }
       };
       List<StringBuilder> last=new ArrayList<>();
       //将不同字符的串形式加入集合中
       for(StringBuilder n:cur){
           if(n!=null){
               last.add(n);
           }
       }
       Collections.sort(last,cc);
       StringBuilder ans=new StringBuilder();
       for(int i=0;i<last.size();i++){
           ans.append(last.get(i));
       }
       return ans.toString();
   }
}
