package Array;

/**
 * @authtor liFei
 * @date 2020/6/5-15:19
 */
public class Solution31 {
    /*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
     */
    public void nextPermutation(int[] nums) {
              int tempIndex=-1;
              int len=nums.length;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(i-1>=0&&nums[i-1]<nums[i]){
                tempIndex=i-1;
                break;
            }
        }
        if(tempIndex==-1){
            QuickSort(nums,0,len-1);
        }else{
            int minMax=nums[tempIndex+1];
            int index=tempIndex+1;
            for (int i = tempIndex+2; i <len ; i++) {//找到右边比此点大的最小值
                if(nums[i]>nums[tempIndex]&&nums[i]<minMax){
                    minMax=nums[i];
                    index=i;
                }
            }
            int temp=nums[tempIndex];
            nums[tempIndex]=nums[index];
            nums[index]=temp;
            QuickSort(nums,tempIndex+1,len-1);
        }
    }
    private void  QuickSort(int []nums,int start,int end){
        int i;
        int j;
        for ( i= start,j=start;  j<end ; j++) {
            if(nums[j]<nums[end]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        int temp=nums[i];
        nums[i]=nums[end];
        nums[end]=temp;
        if(i-1>start){
            QuickSort(nums,start,i-1);
        }
        if(i+1<end){
            QuickSort(nums,i+1,end);
        }
    }
    public void nextPermutation2(int[] nums) {
        int tempIndex=-1;
        int len=nums.length;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(i-1>=0&&nums[i-1]<nums[i]){
                tempIndex=i-1;
                break;
            }
        }
        if(tempIndex==-1){
         reverse(nums,0);
        }else{
            int minMax=nums[tempIndex+1];
            int index=tempIndex+1;
            for (int i = tempIndex+2; i <len ; i++) {//找到右边比此点大的最小值
                if(nums[i]>nums[tempIndex]&&nums[i]<minMax){
                    minMax=nums[i];
                    index=i;
                }
            }
            int temp=nums[tempIndex];
            nums[tempIndex]=nums[index];
            nums[index]=temp;
           reverse(nums,0);
        }
    }
    private void reverse(int []nums,int start){
        int end=nums.length-1;
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
