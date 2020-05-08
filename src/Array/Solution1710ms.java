package Array;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/7-7:26
 */
public class Solution1710ms {
    /*
    如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     */
    public static void main(String[] args) {
        int a[]={3,2};
        majorityElement2(a);
    }
    public int majorityElement(int[] nums) {
        int len=nums.length/2;
        HashMap<Integer,Integer> ans=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:ans.keySet()){
            if(ans.get(key)>len){
                return key;
            }
        }
        return -1;
    }
    public static int majorityElement2(int[] nums) {
        if (nums.length == 0) return -1;
        int sum = 1;
        int rs = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (rs == nums[i]) {
                sum += 1;
            } else {
                sum -= 1;
                if (sum == 0) {
                    rs = nums[i];
                    sum = 1;
                }
            }

        }
        int count=0;
      for (int i=0;i<nums.length;i++){
          if(rs==nums[i]){
              count++;
          }
      }
      if(count>nums.length/2) {
          return rs;
      }else{
          return -1;
      }
    }
}
