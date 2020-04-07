package Array;

public class Solution238 {
    /*
   给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
   其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     */
    //用除法
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int res[]=new int[len];
        int mul=1;
        int count=0;//记录0的个数
        int index=0;//记录只有一个0时的下标
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                mul *= nums[i];
            }else{
                count++;
                index=i;
            }
        }
        if(count>=2){
            return res;
        }else if(count==0) {
            for (int i = 0; i < res.length; i++) {
                res[i] = mul / nums[i];
            }
        }else{
            res[index]=mul;
        }
        return res;
    }
    //不用除法
    public int[] productExceptSelf2(int[] nums) {
        int len=nums.length;
        int res[]=new int[len];
        int mulLeft[]=new int[len];
        int mulRight[]=new int[len];
        int count=len-1;
        mulLeft[0]=1;
        mulRight[0]=1;
        for(int i=1;i<nums.length;i++){
            mulLeft[i]=nums[i-1]*mulLeft[i-1];
            mulRight[i]=nums[count--]*mulRight[i-1];
        }
        for(int i=0;i<len;i++){
            res[i]=mulLeft[i]*mulRight[len-i-1];
        }
        return res;
    }
}
