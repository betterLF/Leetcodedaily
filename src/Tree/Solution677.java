package Tree;

/**
 * @authtor liFei
 * @date 2020/9/17-13:12
 */
public class Solution677 {
    /*
   实现一个 MapSum 类里的两个方法，insert 和 sum。
对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
     */
    class MapSum {
        class node {
            private node[] children;
            private int sum;

            public node() {
                children = new node[26];
                sum = 0;
            }
        }

        /**
         * Initialize your data structure here.
         */
        node root;

        public MapSum() {
            root = new node();
        }

        public void insert(String key, int val) {
            node cur = root;
            for (char c : key.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.sum = val;
        }

        public int sum(String prefix) {
            node cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.children[c - 'a'];
            }
            return dfs(cur);
        }

        public int dfs(node cur) {
            if (cur == null) {
                return 0;
            }
            int ans = cur.sum;
            for (node c : cur.children) {
                ans +=dfs(c);
            }
            return ans;
        }
    }
}
