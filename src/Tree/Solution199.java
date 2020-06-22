package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/6/20-7:32
 */
public class Solution199 {
    /*
    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int count = 1;
            while (!queue.isEmpty()) {
                int nextCount = 0;
                TreeNode temp = new TreeNode(0);
                while (count != 0) {
                    count--;
                    temp = queue.poll();
                    if (temp.left != null) {
                        queue.add(temp.left);
                        nextCount++;
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                        nextCount++;
                    }
                }
                ans.add(temp.val);
                count = nextCount;
            }
            return ans;
        }
    }
}
