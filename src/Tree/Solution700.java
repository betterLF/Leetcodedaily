package Tree;

/**
 * @authtor liFei
 * @date 2020/8/29-12:11
 */
public class Solution700 {
    /*
    给定二叉搜索树（BST）的根节点和一个值。
     你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     */
    TreeNode ans;
    public TreeNode searchBST(TreeNode root, int val) {
        ans=null;
        dfs(root, val);
        return ans;
    }
    private void dfs(TreeNode root,int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            ans = root;
            return;
        }
        if (root.val > val) {
            dfs(root.left, val);
        } else {
            dfs(root.right, val);
        }
    }
}
