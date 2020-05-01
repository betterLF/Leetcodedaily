package BinarySearch;

public class Solution1351 {
    /*
    给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
    请你统计并返回 grid 中 负数 的数目。
     */
    public  int countNegatives(int [][]grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
          count+=BinarySearch(grid[i]);
        }
        return count;
    }
      private int BinarySearch(int nums[]){
          int l1=0;
          int r1=nums.length;
          if(nums[r1-1]>=0){
              return 0;
          }else if(nums[0]<0){
              return nums.length;
          }
          while(nums[(l1+r1)/2]>=0){
             l1=(l1+r1)/2;
          }
          for(int i=(l1+r1)/2-1;i>=0;i--){
              if(nums[i]>=0){
                  return nums.length-i-1;
              }
          }
        return 0;
    }
}
