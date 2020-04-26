package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/24-9:42
 */
public class Solution11 {
    /*

给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai)
和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea(int[] height) {
      int start=0;
      int end=height.length-1;
      int max=Math.min(height[start],height[end])*(end-start);
      while (start<end){
              if(height[start]>height[end]){//将左右两指针中较小的移动，因为如果移动大的后它的面积肯定小于之前的面积
                  end--;                    //(因为此时距离变小，高度<=之前的最小值)
              }else{
                  start++;
              }
              int temp=Math.min(height[start],height[end])*(end-start);
              if(max<temp){
                  max=temp;
              }
          }
      return max;
    }
}
