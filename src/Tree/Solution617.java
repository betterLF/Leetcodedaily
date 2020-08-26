package Tree;

/**
 * @authtor liFei
 * @date 2020/8/24-6:47
 */
public class Solution617 {
    /*
    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            return merge(t1,t2);
    }
    private TreeNode merge(TreeNode t1,TreeNode t2){
        TreeNode cur;
        if(t1!=null&&t2!=null){
            cur=new TreeNode(t1.val+t2.val);
            cur.left=merge(t1.left,t2.left);
            cur.right=merge(t1.right,t2.right);
        }else if(t1==null&&t2!=null){
            cur=t2;
        }else if(t2==null&&t1!=null){
            cur=t1;
        }else{
            return null;
        }
        return cur;
    }
}
