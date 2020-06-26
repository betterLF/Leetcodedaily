package Tree;

/**
 * @authtor liFei
 * @date 2020/6/23-7:16
 */
public class Solution226 {
    /*
    翻转一棵二叉树。
     */
    public TreeNode invertTree(TreeNode root) {
           reverse(root);
           return root;
    }
    private void reverse(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        reverse(node.left);
        reverse(node.right);
    }
}
