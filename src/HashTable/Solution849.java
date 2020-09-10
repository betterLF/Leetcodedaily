package HashTable;

/**
 * @authtor liFei
 * @date 2020/9/7-7:50
 */
public class Solution849 {
    /*
    在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
至少有一个空座位，且至少有一人坐在座位上。
亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
返回他到离他最近的人的最大距离。
     */
    public int maxDistToClosest(int[] seats) {
              int []ans=new int[seats.length];
              int pre=Integer.MIN_VALUE/2;
        for (int i = 0; i <seats.length ; i++) {
            if(seats[i]==1){
                pre=i;
            }else{
                ans[i]=i-pre;
            }
        }
        pre=Integer.MAX_VALUE/2;
        int res=0;
        for (int i = seats.length-1; i >=0 ; i--) {
            if(seats[i]==1){
                pre=i;
            }else{
                ans[i]=Math.min(ans[i],pre-i);
                res=Math.max(ans[i],res);
            }
        }
        return res;
    }
}
