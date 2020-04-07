public class Solution42 {
   /* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    */
   //双指针
   public int trap(int[] height) {
        int len=height.length;
        int maxLeft=0;//左边高度的最值，动态更新
        int maxRight[]=new int[len];
        for(int i=len-2;i>=0;i--){
            maxRight[i]=maxRight[i+1]>height[i+1]?maxRight[i+1]:height[i+1];
        }
          int count=0;
        for(int i=1;i<len-1;i++){
            maxLeft=maxLeft>height[i-1]?maxLeft:height[i-1];
            int temp=Math.min(maxLeft,maxRight[i])-height[i];
            count+=temp>0?temp:0;
        }
        return  count;
   }
   //双指针优化??
   public int trap2(int[] height) {
       int len=height.length;
       int maxLeft=0;//左边高度的最值，动态更新
       int maxRight=0;
       int count=0;
       int left=1;
       int right=len-2;
       for(int i=1;i<len-1;i++){//i只是循环次数
       if(height[left-1]<height[right+1]){//如果左边索引处的值小于右边，说明左右最大值的较小值在左边，从左边开始更
           maxLeft=maxLeft>height[left-1]?maxLeft:height[left-1];//更新左边最大值
           int temp=maxLeft-height[left];
           count+=temp>0?temp:0;
           left++;
       }else{//从右边开始更
           maxRight=maxRight>height[right+1]?maxRight:height[right+1];
           int temp=maxRight-height[right];
           count+=temp>0?temp:0;
           right--;
       }
       }
       return  count;
   }
}
