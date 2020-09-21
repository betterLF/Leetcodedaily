package HashTable;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/9/18-6:35
 */
public class Solution692 {
    /*
    给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     */
//    public List<String> topKFrequent(String[] words, int k) {
//        HashMap<String,Integer> map=new HashMap<>();
//        for (String cur:words){
//            map.put(cur,map.getOrDefault(cur,0)+1);
//        }
//        PriorityQueue<String[]> priorityQueue=new PriorityQueue<>(new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                int count1=Integer.parseInt(o1[1]);
//                int count2=Integer.parseInt(o2[1]);
//                if(count1!=count2){
//                    return count2-count1;
//                }else{
//                    return o1[0].compareTo(o2[0]);
//                }
//            }
//        });
//        for (String key:map.keySet()){
//            priorityQueue.add(new String[]{key,""+map.get(key)});
//        }
//        List<String> ans=new ArrayList<>();
//        for (int i = 0; i <k ; i++) {
//            ans.add(priorityQueue.poll()[0]);
//        }
//        return ans;
//    }
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            int count = map.containsKey(str) ? map.get(str) + 1 : 1;
            map.put(str, count);
        }
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                if (res == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return res;
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(sortList.get(i).getKey());
        }
        return result;
    }
}
