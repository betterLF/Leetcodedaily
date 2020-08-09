package Tree;

/**
 * @authtor liFei
 * @date 2020/8/7-7:09
 */
public class Solution538 {
    /*
    给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
    使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     */
    private int curSum;
    public TreeNode convertBST(TreeNode root) {
           curSum=0;
           suffixDif(root);
           return root;
    }
    private void suffixDif(TreeNode root){
        if(root==null){
            return;
        }
        suffixDif(root.right);
        int cur=root.val;
        root.val+=curSum;
        curSum+=cur;
        suffixDif(root.left);
    }
}
