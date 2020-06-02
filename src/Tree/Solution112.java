package Tree;

/**
 * @authtor liFei
 * @date 2020/6/1-6:53
 */
public class Solution112 {
    /*
    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
    这条路径上所有节点值相加等于目标和。
说明: 叶子节点是指没有子节点的节点。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
             if(root==null){
                 return false;
             }
             sum-=root.val;
             if(root.left==null&&root.right==null){
                 return sum==0;
             }
             return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }


}