package BinarySearch;

/**
 * @authtor liFei
 * @date 2020/4/30-9:35
 */
public class Solution1111 {
    /*
    有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
有效括号字符串类型与对应的嵌套深度计算方法如下图所示：
给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
A 或 B 中的元素在原字符串中可以不连续。
A.length + B.length = seq.length
深度最小：max(depth(A), depth(B)) 的可能取值最小。 
     */
    public int[] maxDepthAfterSplit(String seq) {
        int len=seq.length();
         int ans[]=new int[len];
         char cur[]=seq.toCharArray();
          int depth=0;
         for (int i=0;i<len;i++){
             if(cur[i]=='('){
                 depth++;
                 ans[i]=depth%2;
             }else{
                 ans[i]=depth%2;
                 depth--;
             }
         }
         return ans;
    }
}