package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/6-6:19
 */
public class Solution442 {
    /*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
找到所有出现两次的元素。
你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     */
    public static void main(String[] args) {
        int a[]={1,2,1};
        findDuplicates(a);
    }
    public static List<Integer> findDuplicates(int[] nums) {
      List<Integer> ans=new ArrayList<>();
      for (int i=0;i<nums.length;i++){
          int index=Math.abs(nums[i])-1;//将下标为当前元素值的索引值取反，如果已经小于0说明取反过一次，说明nums[i]的值出现过一次
          if(nums[index]<0){
              ans.add(nums[i]);
          }
          nums[index]=-nums[index];
      }
      return ans;
    }
}
