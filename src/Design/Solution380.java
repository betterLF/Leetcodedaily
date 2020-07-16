package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/7/12-7:06
 */
public class Solution380 {
    /*
    设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
     */
    //HashSet 62ms
//    class RandomizedSet {
//         HashSet<Integer> set;
//         ArrayList<Integer> list;
//        /** Initialize your data structure here. */
//        public RandomizedSet() {
//              set=new HashSet<>();
//              list=new ArrayList<>();
//        }
//
//        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//        public boolean insert(int val) {
//             if(!set.contains(val)){
//                 set.add(val);
//                 list.add(val);
//                 return true;
//             }
//             return false;
//        }
//
//        /** Removes a value from the set. Returns true if the set contained the specified element. */
//        public boolean remove(int val) {
//                   if(set.contains(val)){
//                       set.remove(val);
//                       list.remove((Integer)val);
//                       return true;
//                   }
//                   return false;
//        }
//
//        /** Get a random element from the set. */
//        public int getRandom() {
//            Random random = new Random();
//            int len=list.size();
//            return list.get(random.nextInt(len));
//        }
//    }
    class RandomizedSet {
        HashMap<Integer,Integer> map;
        ArrayList<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(!map.containsKey(val)){
                map.put(val,list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(map.containsKey(val)){
             int lastNum=list.get(list.size()-1);
             int idx=map.get(val);
             map.put(lastNum,idx);//将最后一个元素的索引改成当前要删除的索引
             list.set(idx,lastNum);//将最后一个元素移到当前要删除元素的位置
             map.remove(val);
             list.remove(list.size()-1);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            int len=list.size();
            return list.get(random.nextInt(len));
        }
    }
}
