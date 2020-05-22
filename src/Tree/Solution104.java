package Tree;

/**
 * @authtor liFei
 * @date 2020/5/22-8:11
 */
public class Solution104 {
    /*
    给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
     */
    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
         return preorder(root);
    }
    private int preorder(TreeNode root){
         if(root==null){
             return 0;
         }
         return Math.max(preorder(root.left),preorder(root.right))+1;
    }
}
