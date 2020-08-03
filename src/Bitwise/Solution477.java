package Bitwise;

/**
 * @authtor liFei
 * @date 2020/8/1-6:56
 */
public class Solution477 {
    /*
    两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
计算一个数组中，任意两个数之间汉明距离的总和。
     */
    public int totalHammingDistance(int[] nums) {
      int []zero=new int[32];
      int []one=new int[32];
        for (int i = 0; i <nums.length ; i++) {
            int cur=nums[i];
            for (int j = 0; j <32 ; j++) {
                if((cur&(1<<j))==0){
                    zero[j]++;
                }else{
                    one[j]++;
                }
            }
        }
        int ans=0;
        for (int i = 0; i <32 ; i++) {
            ans+=zero[i]*one[i];
        }
        return ans;
    }
    public int totalHammingDistance2(int[] nums) {
        int ans = 0, count_1;
        for(int i = 0; i< 32; i++){
            count_1 = 0;
            for(int j : nums){
                count_1 += (j >> i) & 1;
            }
            ans += (nums.length - count_1) * count_1;
        }
        return ans;
    }
}
