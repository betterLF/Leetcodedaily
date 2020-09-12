package Tree;

/**
 * @authtor liFei
 * @date 2020/9/9-13:48
 */
public class Solution897 {
    /*
    给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     */
    private TreeNode pre=null;
    private TreeNode ans=null;
    public TreeNode increasingBST(TreeNode root) {
        prefix(root);
        return ans;
    }
    private void prefix(TreeNode cur){
        if(cur==null){
            return;
        }
        prefix(cur.left);
        cur.left=null;
        if(pre==null){
            pre=cur;
            ans=cur;
        }else{
            pre.right=cur;
            pre=pre.right;
        }
        prefix(cur.right);
    }
}
