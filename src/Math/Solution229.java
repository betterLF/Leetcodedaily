package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/29-8:14
 */
public class Solution229 {
    /*
    给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        if(nums.length==0){
            return list;
        }
             int A=0;
             int B=0;
             int aNum=0;
             int bNum=0;
        for (int i =0 ; i <nums.length ; i++) {
                  if(nums[i]==A){//如果是A
                      aNum++;
                      continue;
                  }else if(nums[i]==B){//如果是B
                      bNum++;
                      continue;
                  }else{//如果不是A和B
                      if(aNum==0){
                          A=nums[i];
                          aNum++;
                          continue;
                      }else if(bNum==0){
                          B=nums[i];
                          bNum++;
                          continue;
                      }
                      aNum--;
                      bNum--;
                  }
        }
        aNum=0;
        bNum=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==A){
                aNum++;
            }else if(nums[i]==B){
                bNum++;
            }
        }
        if(aNum>nums.length/3){
            list.add(A);
        }
        if(bNum>nums.length/3){
            list.add(B);
        }
        return list;
    }
}
