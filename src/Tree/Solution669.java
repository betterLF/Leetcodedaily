package Tree;

/**
 * @authtor liFei
 * @date 2020/8/27-6:14
 */
public class Solution669 {
    /*
    给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
    你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    private TreeNode dfs(TreeNode cur, int L, int R) {
        while (cur != null && (cur.val < L||cur.val>R)) {
            cur =cur.val<L? cur.right:cur.left;
        }
        if (cur == null) {
            return null;
        }
        cur.left = dfs(cur.left, L, R);
        cur.right = dfs(cur.right, L, R);
        return cur;
    }
}
