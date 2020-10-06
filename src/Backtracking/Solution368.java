package Backtracking;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/10-7:55
 */
public class Solution368 {
    /*
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
如果有多个目标子集，返回其中任何一个均可。
     */
    //dfs 607ms
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0){
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        PriorityQueue<LinkedList<Integer>> queue=new PriorityQueue<>((n1, n2)->n2.size()-n1.size());
        for (int i = 0; i <nums.length ; i++) {
            if(queue.size()!=0&&queue.peek().size()>=nums.length-i){//如果优先权队列中已经存在集合并且其大小大于当前可能的最大值，直接退出
                break;
            }
            LinkedList<Integer> cur=new LinkedList<>();
            cur.add(nums[i]);
            dfs(queue,cur,i,nums,nums[i]);
        }
        return queue.poll();
    }
    private  void dfs(PriorityQueue<LinkedList<Integer>> queue,LinkedList<Integer> cur,int start,int []nums,int num){
        if(start==nums.length-1){//如果正好加到末尾
            queue.add(new LinkedList<>(cur));
            return;
        }
        for (int i = start+1; i<nums.length ; i++) {
            if(queue.size()!=0&&queue.peek().size()>=nums.length-i+cur.size()){//如果当前队列长度最大值大于当前可能的最大值直接退出
                return;
            }
            if(nums[i]%num==0){
                cur.add(nums[i]);
                dfs(queue,cur,i,nums,nums[i]);
                cur.removeLast();
            }
        }
        queue.add(new LinkedList<>(cur));
    }
    //dp
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
             int []dp=new int[nums.length];//下标代表以当前位置为结尾的最长子序列长度
             Arrays.sort(nums);
             Arrays.fill(dp,1);
             int max=1;//最长子序列长度
             int maxIndex=0;//其对应的最后一个元素
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i-1; j>=0 ; j--) {
                if(nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>max){
                maxIndex=i;
                max=dp[i];
            }
        }
        LinkedList<Integer> ans=new LinkedList<>();
        int cur=maxIndex;
        ans.addFirst(nums[cur]);
        max--;
        int j=cur-1;
        while (max>0&&j>=0){
            if(dp[cur]==dp[j]+1&&nums[cur]%nums[j]==0){
                ans.addFirst(nums[j]);
                max--;
                cur=j;
            }
            j--;
        }
        return ans;
    }
}
