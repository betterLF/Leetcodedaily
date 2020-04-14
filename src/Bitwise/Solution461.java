package Bitwise;

/**
 * @authtor liFei
 * @date 2020/4/14-9:45
 */
public class Solution461 {
    /*
    两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    给出两个整数 x 和 y，计算它们之间的汉明距离。
    */
    public static void main(String[] args) {
        System.out.println( hammingDistance(3,1));
    }
    public static int hammingDistance(int x, int y) {
         int count=0;
         int count2=0;
         while((x>>count2)!=0||(y>>count2)!=0){
             if(((x>>count2)&1)!=((y>>count2)&1)){
                 count++;
             }
             count2++;
         }
         return count;
    }
}
