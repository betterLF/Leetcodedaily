package Tree;

/**
 * @authtor liFei
 * @date 2020/6/13-9:40
 */
public class Solution114 {
    /*
    给定一个二叉树，原地将它展开为一个单链表。
     */
    public void flatten(TreeNode root) {
           if(root==null){
               return;
           }
       flattenChild(root);

    }
    private TreeNode flattenChild(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode temp=root.right;
        root.right=flattenChild(root.left);
        root.left=null;
        TreeNode newTemp=root;
        while (newTemp.right!=null){
           newTemp=newTemp.right;
        }
        newTemp.right=flattenChild(temp);
        return root;
    }
}
