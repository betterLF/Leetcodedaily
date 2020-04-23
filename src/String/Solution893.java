package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/4/22-16:20
 */
public class Solution893 {
    /*
    你将得到一个字符串数组 A。
如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是
特殊等价的。
返回 A 中特殊等价字符串组的数量。
     */
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> ans=new HashSet<>();
        for(String s:A){
            int count[]=new int[52];
            char c[]=s.toCharArray();
            for(int i=0;i<c.length;i++) {
                count[c[i] - 'a' + 26 * (i % 2)]++;//将偶数下标的字母及其出现次数存入前26个位置，
                //将奇数下标的字母及其出现次数存入后26个位置
                       }
                ans.add(Arrays.toString(count));//如果count不同就加入ans，如果它们是等价的就进不去
            }
        return ans.size();
    }
}
