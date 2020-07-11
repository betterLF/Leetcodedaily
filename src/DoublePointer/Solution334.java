package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/7/8-6:53
 */
public class Solution334 {
    /*
    给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
数学表达式如下:
如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     */
    public boolean increasingTriplet(int[] nums) {
          if(nums.length==0){
              return false;
          }
          int min=Integer.MAX_VALUE;
          int max=Integer.MAX_VALUE;
          for (int num:nums){
              if(num<=min){//更新此时的最小值
                  min=num;
              }else if(num<=max){//两种情况:此时的max是前一个最小值对应的min，此时如果成立更新了当前最小值右边的最大值
                  max=num;      //此时的max对应当前最小值
              }else{//此时说明大于最大值，而最大值肯定对应一个最小值(即此时前面肯定出现一对符合条件的min<max)
                  return true;
              }
          }
          return false;
    }
}
