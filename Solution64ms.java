package String;

/**
 * @authtor liFei
 * @date 2020/4/21-7:11
 */
public class Solution64ms {
    /*
    求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        boolean x=n>1&&(n+=sumNums(n-1))>0;
        return n;
    }
}
