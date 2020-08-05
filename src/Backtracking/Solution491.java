package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/3-7:33
 */
public class Solution491 {
    /*
    给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     */
    //超时间限制
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> ans=new ArrayList<>();
//        for (int i = 0; i <nums.length ; i++) {
//            List<List<Integer>> cur=new ArrayList<>();
//            List<Integer> first=new ArrayList<>();
//            first.add(nums[i]);
//            cur.add(first);
//            for (int j = i+1; j <nums.length ; j++) {
//                if(nums[j]>=nums[i]){
//                    int curSize=cur.size();
//                    for (int k = 0; k <curSize ; k++) {
//                         List<Integer> cc= cur.get(k);
//                        if(nums[j]>=cc.get(cc.size()-1)){
//                            List<Integer> add=new ArrayList<>(cc);
//                            add.add(nums[j]);
//                            cur.add(add);
//                        }
//                    }
//                }
//            }
//            for (int j = 1; j <cur.size() ; j++) {
//                if(!ans.contains(cur.get(j))) {
//                    ans.add(cur.get(j));
//                }
//            }
//        }
//        return ans;
//    }
    List<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans=new ArrayList<>();
        dfs(nums,new ArrayList<Integer>(),0);
        return ans;
    }
    private void dfs(int []nums,ArrayList<Integer> cur,int index){
        if(index==nums.length){//如果当前到达末尾，直接返回
            if(cur.size()>=2){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        if(cur.size()==0||nums[index]>=cur.get(cur.size()-1)){
            cur.add(nums[index]);//加入该元素
            dfs(nums,cur,index+1);
            cur.remove(cur.size()-1);//复原，不加入该元素
        }
        if(index>0&&cur.size()!=0&&nums[index]==cur.get(cur.size()-1)){
            return;
        }
        dfs(nums,cur,index+1);//该元素不放入集合中
    }
}
