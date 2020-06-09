package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/7-7:12
 */
public class Solution47 {
    /*
    给定一个可包含重复数字的序列，返回所有不重复的全排列。
     */

    List<List<Integer>> ans;
    boolean []flag;
    Integer []temp;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans=new ArrayList<>();
        flag=new boolean[nums.length];
        temp=new Integer[nums.length];
        Arrays.sort(nums);//对原数组排序，方便剪枝
        getAns2(nums,0);
        return ans;
    }
    //pos为当前要赋值的下标
    private void getAns2(int []nums,int index){
        if(index==nums.length){
               ans.add(new ArrayList<>(Arrays.asList(temp)));
            return;
        }
        for (int i = 0; i <nums.length; i++) {
            if(flag[i]){
                continue;
            }
            if(i>0&&nums[i-1]==nums[i]&&!flag[i-1]){
                continue;
            }
            flag[i]=true;
            temp[index]=nums[i];
            getAns2(nums,index+1);
            flag[i]=false;//回溯
        }
    }
}
