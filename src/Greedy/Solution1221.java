package Greedy;

/*
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
返回可以通过分割得到的平衡字符串的最大数量。
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
                if (lCount == rCount) {
                    count++;
                    lCount = 0;
                    rCount = 0;
                }
            } else {
                rCount++;
                if (lCount == rCount) {
                    count++;
                    lCount = 0;
                    rCount = 0;
                }

            }
        }
        return count;
    }
    //同样的解法，别人思路很棒
    public int balancedStringSplit2(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;
    }
}
