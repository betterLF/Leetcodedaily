package Array;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/5/18-6:37
 */
public class Solution152 {
    /*
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
     */
    public int maxProduct(int[] nums) {
             ArrayList<Integer> zero=new ArrayList<>();
             for (int i=0;i<nums.length;i++){
                 if(nums[i]==0){
                     zero.add(i);
                 }
             }
             if(zero.size()==0){
                 return (int)getCurMax(nums,0,nums.length-1);
             }
             long ans=0;
        for (int i = 0; i <zero.size() ; i++) {
            if(i!=0){
                ans=Math.max(ans,getCurMax(nums,zero.get(i-1)+1,zero.get(i)-1));
            }else{
                ans=Math.max(ans,getCurMax(nums,0,zero.get(i)-1));
            }
        }
        ans=Math.max(ans,getCurMax(nums,zero.get(zero.size()-1)+1,nums.length-1));
        return (int)ans;
    }
    //返回当前不含有0的字数组最大值
    private long getCurMax(int[] nums,int start,int end){
        if(end<start){
            return 0;
        }
        if(end-start==0){//如果字数组只有一个元素，就返回
            return nums[start];
        }
        //先判断负数个数
        int count=0;
         int []mul=new int[end-start+2];
         mul[0]=1;
         int count2=1;
        ArrayList<Integer> belowZero=new ArrayList<>();//记录负数出现的位置
        for (int i = start; i <=end ; i++) {
            mul[count2]=nums[i]*mul[count2-1];
            count2++;
            if(nums[i]<0){
                count++;
                belowZero.add(i);
            }
        }
        if(count%2==0){//如果负数为偶位数
            return mul[end-start+1];
        }else{//如果负数为奇数，最大值在两个之间产生
            if(count>2) {
                long max1 = mul[belowZero.get(count - 1) - start ];//从第一个负数到倒数第一个负数出现为止
                long max2 = mul[end-start+1] / mul[belowZero.get(0) - start + 1];//从第二个负数到最后一个负数为止
                return Math.max(max1, max2);
            }else{
                int index=belowZero.get(0);
                if(index!=start) {
                    return Math.max(mul[index-start],mul[end-start+1]/mul[index-start+1]);
                }else{
                    return mul[end-start+1]/mul[1];
                }
            }
        }
    }
}
