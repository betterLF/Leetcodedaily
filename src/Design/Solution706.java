package Design;

/**
 * @authtor liFei
 * @date 2020/9/1-9:40
 */
public class Solution706 {
    /*
   不使用任何内建的哈希表库设计一个哈希映射
具体地说，你的设计应该包含以下的功能
put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
remove(key)：如果映射中存在这个键，删除这个数值对。
     */
//    class MyHashMap {
//           boolean []flag;
//           int []count;
//        /** Initialize your data structure here. */
//        public MyHashMap() {
//             flag=new boolean[10000001];
//             count=new int[10000001];
//        }
//
//        /** value will always be non-negative. */
//        public void put(int key, int value) {
//          flag[key]=true;
//          count[key]=value;
//        }
//
//        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//        public int get(int key) {
//           if(flag[key]){
//               return count[key];
//           }
//           return -1;
//        }
//
//        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//        public void remove(int key) {
//              flag[key]=false;
//        }
//    }
//    class MyHashMap {
//        private static class Node {
//            public int key;
//            public int value;
//            public Node next;
//
//            public Node(int key, int value) {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//        private Node[] table = new Node[10000];
//
//        /**
//         * Initialize your data structure here.
//         */
//        public MyHashMap() {
//        }
//
//        /**
//         * value will always be non-negative.
//         */
//        public void put(int key, int value) {
//            int hash = hashcode(key);
//            if (table[hash] == null) {
//                table[hash] = new Node(key, value);
//            }
//            else{
//                Node node = table[hash];
//                Node prev = node;
//                while (node != null) {
//                    if(node.key == key){
//                        node.value = value;
//                        return;
//                    }
//                    prev = node;
//                    node = node.next;
//                }
//                prev.next = new Node(key, value);
//            }
//        }
//
//        /**
//         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
//         */
//        public int get(int key) {
//            Node node = table[hashcode(key)];
//            while (node != null) {
//                if(node.key == key){
//                    return node.value;
//                }
//                node = node.next;
//            }
//            return -1;
//        }
//
//        /**
//         * Removes the mapping of the specified value key if this map contains a mapping for the key
//         */
//        public void remove(int key) {
//            Node head = table[hashcode(key)];
//            Node node = head;
//            Node prev = head;
//            while (node != null) {
//                if(node.key == key){
//                    if(node.equals(head)){
//                        table[hashcode(key)] = head.next;
//                    }
//                    else{
//                        prev.next = node.next;
//                    }
//                }
//                prev = node;
//                node = node.next;
//            }
//        }
//
//        private int hashcode(int value) {
//            return value % 10000;
//        }
//    }

}
