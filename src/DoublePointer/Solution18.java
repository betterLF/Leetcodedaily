package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/4-7:37
 */
public class Solution18 {
    /*
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
    使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     */
    //回溯，超限制
    List<List<Integer>> ans;
    int t;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        t=target;
        ans = new ArrayList<>();
        if (nums.length <= 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3 ; i++) {
            ArrayList c=new ArrayList<Integer>();
            c.add(nums[i]);
            back(c,nums, target-nums[i], 1,i);
            c.remove(c.size()-1);
        }
        return ans;
    }
    private void back(List<Integer> temp,int []nums,int nowTarget,int count,int index){
        if(count==4){
            if(nowTarget==0&&!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(count+nums.length-index-1<4){
            return;
        }
        for (int i = index+1; i <nums.length ; i++) {
            temp.add(nums[i]);
            back(temp, nums, nowTarget-nums[i], count+1, i);
            temp.remove(temp.size()-1);
        }
    }
    //双指针
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        if (nums.length <= 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3 ; i++) {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target){
              continue;
            }
            for (int j = i+1; j <nums.length-2 ; j++) {
//                ArrayList cur=new ArrayList<Integer>();
//                cur.add(nums[i]);
//                cur.add(nums[j]);
                int nowTarget=target-nums[i]-nums[j];
                int m=j+1;
                int n=nums.length-1;
                while (m<n){
                    if(nums[m]+nums[n]<nowTarget){
                        m++;
                    }else if(nums[m]+nums[n]> nowTarget){
                        n--;
                    }else{
//                        cur.add(nums[m]);
//                        cur.add(nums[n]);
                     List cur= Arrays.asList(nums[i],nums[j],nums[m],nums[n]);
                        if(!ans.contains(cur)) {
                            ans.add(new ArrayList<>(cur));
                        }
//                        cur.remove(cur.size()-1);
//                        cur.remove(cur.size()-1);
                        m++;
                        n--;
                    }
                }
            }
        }
        return ans;
    }
}
