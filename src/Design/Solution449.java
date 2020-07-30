package Design;



/**
 * @authtor liFei
 * @date 2020/7/27-7:38
 */
public class Solution449 {
    /*
  序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
  或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
编码的字符串应尽可能紧凑。
注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
     */
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    class Codec {
        // Encodes a tree to a single string.
        //BST的前序遍历结果
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            return sb.substring(0, sb.length() - 1);
        }

        private void helper(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            //拼接当前节点
            sb.append(root.val).append(",");
            helper(root.left, sb);
            helper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            String[] arr = data.split(",");
            return builder(arr, 0, arr.length - 1);
        }

        private TreeNode builder(String[] arr, int lo, int hi) {
            if (lo > hi) return null;
            TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
            //找到第一个比首元素大的元素位置
            int index = hi + 1;
            for (int i = lo + 1; i <= hi; i++) {
                if (Integer.valueOf(arr[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            //递归构建子树
            root.left = builder(arr, lo + 1, index - 1);
            root.right = builder(arr, index, hi);
            return root;
        }
    }
}
