package String;

/**
 * @authtor liFei
 * @date 2020/9/5-11:54
 */
public class Solution806 {
    /*
    我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，
    那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， 
    widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
     */
//    public int[] numberOfLines(int[] widths, String S) {
//        int row=0;
//        int curLoss=100;
//        for (char cur:S.toCharArray()) {
//            int len=widths[cur-'a'];
//            if(curLoss-len>=0){
//                curLoss-=len;
//            }else{
//                row++;
//                curLoss=100-len;
//            }
//        }
//        if(curLoss==0){
//            return new int[]{row,100};
//        }else{
//            return new int[]{row+1,100-curLoss};
//        }
//    }
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1, width = 0;
        for(char c : S.toCharArray()) {
            int w = widths[c - 'a'];
            width = width + w;
            if(width > 100) {
                lines = lines + 1;
                width = w;
            }
        }

        return new int[]{lines, width};

    }
}
