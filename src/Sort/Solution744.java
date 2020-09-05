package Sort;

/**
 * @authtor liFei
 * @date 2020/9/2-12:24
 */
public class Solution744 {
    /*
给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
在比较时，字母是依序循环出现的。举个例子：
如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i <letters.length ; i++) {
            if(letters[i]>target){
                return letters[i];
            }
        }
        return letters[0];
    }
}
