package Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @authtor liFei
 * @date 2020/7/10-20:12
 */
public class Solution373 {
    /*
给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue=new PriorityQueue<>((n1,n2)->(n2.get(0)+n2.get(1))-(n1.get(0)+n1.get(1)));//维护大小为k的大顶堆
        int min=Math.min(nums1.length,k);
        int min2=Math.min(nums2.length,k);
        for (int i = 0; i <min ; i++) {
            for (int j = 0; j <min2 ; j++) {
                    if(queue.size()!=k){
                        List<Integer> cur=new ArrayList<>();
                        cur.add(nums1[i]);
                        cur.add(nums2[j]);
                        queue.add(cur);
                    }else if(queue.peek().get(0)+queue.peek().get(1)>nums1[i]+nums2[j]){
                        queue.poll();
                        List<Integer> cur=new ArrayList<>();
                        cur.add(nums1[i]);
                        cur.add(nums2[j]);
                        queue.add(cur);
                    }else{
                        break;
                    }
                }
            }
        List<List<Integer>> ans=new ArrayList<>();
        while (!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++) pq.offer(new int[]{i, 0});

        while(pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) pq.offer(new int[]{pair[0], pair[1]+1});
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }
}
