import java.util.Arrays;

public class Solution1313 {
    /*
    给你一个以行程长度编码压缩的整数列表 nums 。考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
    每一对都表示解压后子列表中有 freq 个值为 val 的元素，
    你需要从左到右连接所有子列表以生成解压后的列表。  请你返回解压后的列表。
     */
    public int []decompressRLElist(int nums[]){
        int count=0;//统计结果长度
         for(int i=0;i<nums.length/2;i++){
             count+=nums[2*i];
         }
         int res[]=new int[count];
         int count2=0;
         for(int i=0;i<nums.length/2;i++){
             while(nums[2*i]>0){
                 res[count2++]=nums[2*i+1];
                 nums[2*i]--;
             }
         }
         return res;
    }
    public int []decompressRLElist2(int nums[]){
        int count=0;//统计结果长度
        for(int i=0;i<nums.length/2;i++){
            count+=nums[2*i];
        }
        int res[]=new int[count];
        int count2=0;
       for(int i=0;i<count;i++){
           if(nums[count2]>0){
               res[i]=nums[count2+1];
               nums[count2]--;
           }else{
               count2+=2;
               res[i]=nums[count2+1];
               nums[count2]--;
           }

       }
        return res;
    }
    public int []decompressRLElist3(int nums[]){
        int count=0;//统计结果长度
        for(int i=0;i<nums.length;i+=2){
            count+=nums[i];
        }
        int res[]=new int[count];
        int count2=0;
        for(int i=0;i<nums.length;i+=2){
            while(nums[i]>0){
                res[count2++]=nums[i+1];
                nums[i]--;
            }
        }
        return res;
    }
}
