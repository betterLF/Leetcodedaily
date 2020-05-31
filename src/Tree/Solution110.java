package Tree;

/**
 * @authtor liFei
 * @date 2020/5/30-7:02
 */
public class Solution110 {
    /*
    给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(count(root.left)-count(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }else{
            return false;
        }
    }
    private int count(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        return Math.max(count(treeNode.left),count(treeNode.right))+1;
    }
}
