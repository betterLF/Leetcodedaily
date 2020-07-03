package Math;

/**
 * @authtor liFei
 * @date 2020/6/29-18:53
 */
public class Solution264 {
    /*
    编写一个程序，找出第 n 个丑数。
丑数就是质因数只包含 2, 3, 5 的正整数。
     */
    public int nthUglyNumber(int n) {
         if(n==0){
             return 0;
         }
       int []num=new int[n];
         num[0]=1;
         int p1=0,p2=0,p3=0;
        for (int i = 1; i <n ; i++) {
            num[i]=Math.min(Math.min(num[p1]*2,num[p2]*3),num[p3]*5);
            if(num[i]==num[p1]*2){
                p1++;
            }
            if(num[i]==num[p2]*3){
                p2++;
            }
            if(num[i]==num[p3]*5){
                p3++;
            }
        }
        return num[n-1];
    }
}
