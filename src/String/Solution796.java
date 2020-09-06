package String;

/**
 * @authtor liFei
 * @date 2020/9/4-11:54
 */
public class Solution796 {
    /*
    给定两个字符串, A 和 B。
A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，
在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
     */
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
          StringBuilder longString=new StringBuilder();
          longString.append(A).append(A);
          return longString.lastIndexOf(B)!=-1;
    }
}
