package Math;

/**
 * @authtor liFei
 * @date 2020/6/5-8:21
 */
public class Solution1281 {
    /*
    给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     */
    public int subtractProductAndSum(int n) {
        String temp=Integer.toString(n);
        char []c=temp.toCharArray();
        int mul=1;
        int sum=0;
        for (char cur:c){
            int t=cur-'0';
            mul*=t;
            sum+=t;
        }
        return mul-sum;
    }
}
