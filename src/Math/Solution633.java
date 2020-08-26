package Math;

/**
 * @authtor liFei
 * @date 2020/8/24-6:57
 */
public class Solution633 {
    /*
    给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     */
//    public boolean judgeSquareSum(int c) {
//        for (long a = 0; a * a <= c; a++) {
//            double b = Math.sqrt(c - a * a);
//            if (b == (int) b)
//                return true;
//        }
//        return false;
//    }
    public boolean judgeSquareSum(int c) {

        int len = (int) Math.sqrt(c);

        int left = 0;
        int right = len;
        int tmp;

        while (left<=right){

            tmp = left*left + right*right;
            if (tmp<c){
                left++;
            }
            if (tmp == c){
                return true;
            }if (tmp>c){
                right--;
            }
        }
        return false;
    }
}
