package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/8-18:26
 */
public class Solution872 {
    /*
请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     */
          public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
              this.right = right;
          }
      }
      int i;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        i=0;
        List<Integer> leaves1 = new ArrayList();
        dfs(root1, leaves1);
        dfs02(root2,leaves1);
        return i==leaves1.size() ;
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
            return;
        }
    }
    public  void dfs02(TreeNode node, List<Integer> leafValues) {
        if(i>leafValues.size()){
            return;
        }
        if (node != null) {
            if (node.left == null && node.right == null) {
                if(i==leafValues.size()){
                    i++;
                    return;
                }
                if (node.val != leafValues.get(i)) {
                    return;
                } else {
                    i++;
                }
            }
           dfs02(node.left, leafValues);

           dfs02(node.right, leafValues);

        }
        }
}
