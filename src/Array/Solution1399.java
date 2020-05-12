package Array;

/**
 * @authtor liFei
 * @date 2020/5/10-18:46
 */
public class Solution1399 {
    /*
给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
     */
    public static void main(String[] args) {
        countLargestGroup(13);
    }
    public static int countLargestGroup(int n) {
           if(n<10){
               return n;
           }
          int ans[]=new int[37];
           for (int i=1;i<=n;i++){
               ans[getCount(i)]++;
           }
           int max=ans[0];
             for (int i=1;i<37;i++){
                 if(max<ans[i]){
                     max=ans[i];
                 }
             }
           int res=0;
         for (int num:ans){
             if(num==max){
                 res++;
             }
         }
           return res;

    }
    private static int getCount(int t){
        int n = 0;
        while (t > 0){
            n += t%10;
            t /= 10;
        }
        return n;
    }
}
