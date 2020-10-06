package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/6-18:47
 */
public class Solution46 {
    /*
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     */
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
       ans=new ArrayList<>();
       List<Integer> curAns=new LinkedList<>();
       List<Integer> num=new LinkedList<>();
        for (int i = 0; i <nums.length ; i++) {
            num.add(nums[i]);
        }
                getAns(curAns,num);
        return ans;
    }
    private void getAns(List<Integer> curAns,List<Integer> num){
        if(num.size()==0){//如果没有数了，就将当前结果加入结果集并返回
            ans.add(new ArrayList<>(curAns));
            return;
        }
        for (int i = 0; i <num.size() ; i++) {
            int temp=num.get(i);
            curAns.add(temp);
            num.remove(i);
            getAns(curAns,num);
            num.add(i,temp);//回溯
            curAns.remove(curAns.size()-1);
        }
    }
    boolean []flag;
    Integer []temp;
    public List<List<Integer>> permute2(int[] nums) {
        ans=new ArrayList<>();
        flag=new boolean[nums.length];
        temp=new Integer[nums.length];
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
            flag[i]=true;
             temp[index]=nums[i];
            getAns2(nums,index+1);
            flag[i]=false;//回溯
        }
    }
}
