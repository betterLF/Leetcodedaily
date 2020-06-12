package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/10-7:19
 */
public class Solution77 {
    /*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    public List<List<Integer>> ans;
    public  int target;
    public List<List<Integer>> combine(int n, int k) {
             ans=new LinkedList<>();
             target=k;
             if(n<k){//如果没有k个数
                 return ans;
             }
             Integer []nums=new Integer[k];
             Back(nums,0,n,1);
             return ans;
    }
    private void Back(Integer []nums,int curK,int n,int startIndex){
        if(curK==target){
            ans.add(new ArrayList<>(Arrays.asList(nums)));
            return;
        }
        for (int i=startIndex; i <=n ; i++) {
            if(curK+n-i+1<target){//剪枝
                break;
            }
                nums[curK]=i;
                Back(nums,curK+1,n,i+1);
            }
        }
        //方法二：集合存放当前结果
        public List<List<Integer>> combine2(int n, int k) {
            ans=new ArrayList<>();
            target=k;
            if(n<k){//如果没有k个数
                return ans;
            }
            List<Integer> cur=new ArrayList<>();
            Back2(cur,0,n,1);
            return ans;
        }
    private void Back2(List<Integer> cur,int curK,int n,int startIndex){
        if(curK==target){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i=startIndex; i <=n; i++) {
            if(curK+n-i+1<target){//剪枝
                break;
            }
               cur.add(i);
            Back2(cur,curK+1,n,i+1);
            cur.remove(cur.size()-1);
        }
    }
    }

