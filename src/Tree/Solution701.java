package Tree;

/**
 * @authtor liFei
 * @date 2020/9/19-7:23
 */
public class Solution701 {
    /*
    给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
         TreeNode cur=root;
         while (true){
             if(cur.val>val&&cur.left!=null){
                 cur=cur.left;
             }else if(cur.val>val){
                 cur.left=new TreeNode(val);
                 break;
             }
             if(cur.val<val&&cur.right!=null){
                cur=cur.right;
             }else if(cur.val<val){
                 cur.right=new TreeNode(val);
                 break;
             }
         }
         return root;
    }

}
