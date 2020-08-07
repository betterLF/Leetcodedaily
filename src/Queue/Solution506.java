package Queue;

import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/8/5-6:25
 */
public class Solution506 {
    /*
    给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
    前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
(注：分数越高的选手，排名越靠前。)
     */
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<int []> queue=new PriorityQueue<>((n1,n2)->n1[0]-n2[0]);
        for (int i = 0; i <nums.length ; i++) {
            queue.add(new int[]{nums[i],i});
        }
        int len=nums.length;
        String []ans=new String[len];
        while (queue.size()>3){
            ans[queue.poll()[1]]=Integer.toString(len);
            len--;
        }
        if(queue.size()==3){
            ans[queue.poll()[1]]="Bronze Medal";
        }
        if(queue.size()==2){
            ans[queue.poll()[1]]="Silver Medal";
        }
        if(queue.size()==1){
            ans[queue.poll()[1]]="Gold Medal";
        }
        return ans;
    }
}
