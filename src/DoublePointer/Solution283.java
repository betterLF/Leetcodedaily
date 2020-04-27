package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/25-8:25
 */
public class Solution283 {
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {//5ms
        int zeroIndex=-1;
        for (int i = 0; i <nums.length ; i++) {
             if(nums[i]==0){
                 zeroIndex=i;
                 for (int j=zeroIndex;j<nums.length;j++){
                     if(nums[j]!=0){
                         int temp=nums[j];
                         nums[zeroIndex]=temp;
                         nums[j]=0;
                         break;
                     }
                 }
             }
        }
    }
    public void moveZeroes2(int[] nums) {//0ms
        int zeroNum=0;
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
          if(nums[i]==0){
              zeroNum++;
          }else{
              nums[count]=nums[i];
              count++;
          }
        }
        while (count!=nums.length){
            nums[count]=0;
            count++;
        }
    }
}
