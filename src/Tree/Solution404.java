package Tree;

/**
 * @authtor liFei
 * @date 2020/7/16-18:32
 */
public class Solution404 {
    /*
    计算给定二叉树的所有左叶子之和。
     */
    public int ans;
    public int sumOfLeftLeaves(TreeNode root) {
       ans=0;
       dfs(root);
       return ans;
    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            ans+=root.left.val;
        }
            dfs(root.left);
            dfs(root.right);
    }
}
