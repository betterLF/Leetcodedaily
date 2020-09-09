package DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/6-12:18
 */
public class Solution830 {
    /*
    在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
最终结果按照字典顺序输出。
     */
    public List<List<Integer>> largeGroupPositions(String S) {
      int start=0;
      int preChar=' ';
      char []c=S.toCharArray();
      List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i <c.length ; i++) {
            if(c[i]!=preChar){
                if(i-start>=3){
                    ArrayList<Integer> cur=new ArrayList<>();
                    cur.add(start);
                    cur.add(i-1);
                    ans.add(cur);
                }
                start=i;
                preChar=c[i];
            }
        }
        if(c.length-1-start>=3){
            ArrayList<Integer> cur=new ArrayList<>();
            cur.add(start);
            cur.add(c.length-1);
            ans.add(cur);
        }
        return ans;
    }
}
