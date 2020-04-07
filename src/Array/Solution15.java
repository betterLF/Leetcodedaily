import java.util.*;
/*
给你一个包含 n 个整数的数组 nums，
判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
请你找出所有满足条件且不重复的三元组。  注意：答案中不可以包含重复的三元组。
 */
public class Solution15 {
    public static List<List<Integer>> threeNum(int []nums){
        List<List<Integer>> result=new LinkedList<>();
        if(nums.length<3){//数组个数小于3
            return result;
        }
        Arrays.sort(nums);
        if(nums[0]+nums[1]+nums[2]>0){
            return result;
        }
        //num[i]代表三元素的最小值
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){//去重，关键！
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int m=nums[i]+nums[j]+nums[k];
                if(m==0){
                    result.add(Arrays.asList(nums[i],+nums[j],nums[k]));
                    while(j<k&&nums[j+1]==nums[j]){
                        j++;
                    }//去重，关键！
                    while(j<k&&nums[k-1]==nums[k]){
                        k--;
                    }//去重，关键！
                    k--;
                    j++;
                }else if(m>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }

}
