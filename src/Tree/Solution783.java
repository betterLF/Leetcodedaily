package Tree;

/**
 * @authtor liFei
 * @date 2020/9/4-11:41
 */
public class Solution783 {
    /*
    给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
     */
    int preVal;
   int ans;
   boolean flag;
    public int minDiffInBST(TreeNode root) {
       ans=Integer.MAX_VALUE;
       preVal=0;
       flag=false;
       prefix(root);
       return ans;
    }
    private void prefix(TreeNode cur){
        if(cur==null||ans==1){
            return;
        }
        prefix(cur.left);
        if(flag==false) {
            flag=true;
        }else {
            ans = Math.min(cur.val - preVal, ans);
        }
        preVal=cur.val;
        prefix(cur.right);
    }
}
