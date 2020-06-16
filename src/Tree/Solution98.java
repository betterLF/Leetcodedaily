package Tree;

/**
 * @authtor liFei
 * @date 2020/6/13-6:30
 */
public class Solution98 {
    /*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
     */
    private long ans;
    private boolean flag;
    public boolean isValidBST(TreeNode root) {
           ans=-(long) Math.pow(2,32)-1;
           flag=true;
           if(root==null){
               return true;
           }
           return infix(root);

    }
    private boolean infix(TreeNode root){
        if(flag==false){
            return flag;
        }
        if(root.left!=null){
                infix(root.left);
        }
        if(root.val>ans){
            ans=root.val;
        }else{
            flag=false;
            return flag;
        }
        if(root.right!=null){
            infix(root.right);
        }
        return flag;
    }
}
