package Design;

/**
 * @authtor liFei
 * @date 2020/8/31-7:56
 */
public class Solution705 {
    /*
    不使用任何内建的哈希表库设计一个哈希集合
具体地说，你的设计应该包含以下的功能
add(value)：向哈希集合中插入一个值。
contains(value) ：返回哈希集合中是否存在这个值。
remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
     */
//    class MyHashSet {
//        ArrayList<Integer> ans;
//        public MyHashSet() {
//        ans=new ArrayList<>();
//        }
//
//        public void add(int key) {
//         ans.add(key);
//        }
//
//        public void remove(int key) {
//             while (contains(key)){
//                 ans.remove((Integer)key);
//             }
//        }
//
//        public boolean contains(int key) {
//             return ans.contains(key);
//             }
//        }
    class MyHashSet {
     boolean []cache;
        public MyHashSet() {
         cache=new boolean[1000001];
        }

        public void add(int key) {
           cache[key]=true;
        }

        public void remove(int key) {
              cache[key]=false;
        }

        public boolean contains(int key) {
            return cache[key];
        }
    }
}
