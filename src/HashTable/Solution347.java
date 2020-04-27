package HashTable;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/11-8:19
 */
public class Solution347 {
    /*
    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>  res=new HashMap<>();
        int len=nums.length;
        //key=元素，value=出现次数
        for (int i = 0; i <len ; i++) {
            if(res.containsKey(nums[i])){
                res.put(nums[i],res.get(nums[i])+1);
            }else{
                res.put(nums[i],1);
            }
        }
        List<List<Integer>> ans=new LinkedList<>();
        Set<Integer> integers = res.keySet();
        for(Integer cur:integers){
           List<Integer> n=new LinkedList<>();
           n.add(cur);
           n.add(res.get(cur));
           ans.add(n);
        }
        Comparator<List<Integer>>  temp=new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1)-o1.get(1);
            }
        };
        Collections.sort(ans,temp);
        List<Integer> last=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            last.add(ans.get(i).get(0));
        }
        return last;
    }
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer>  res=new HashMap<>();
        int len=nums.length;
        //key=元素，value=出现次数
        for (int i = 0; i <len ; i++) {
            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>((n1,n2)->res.get(n1)-res.get(n2));//以出现的次数排序，小顶堆
        for(int n:res.keySet()){
           heap.add(n);
           if(heap.size()>k){//使得剩下的k个元素是最大的
               heap.poll();
           }
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
