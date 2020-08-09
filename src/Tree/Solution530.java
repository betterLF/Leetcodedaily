package Tree;

/**
 * @authtor liFei
 * @date 2020/8/6-7:11
 */
public class Solution530 {
    /*
    给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     */
    private int pre;
    private int ans;
    public int getMinimumDifference(TreeNode root) {
    pre=-1;
    ans=Integer.MAX_VALUE;
    suffix(root);
    return ans;
    }
    private void suffix(TreeNode curRoot){
        if(curRoot==null||ans==1){
            return;
        }
        suffix(curRoot.left);
        if(pre==-1){
            pre=curRoot.val;
        }else{
            ans=Math.min(ans,Math.abs(curRoot.val-pre));
            pre=curRoot.val;
        }
        suffix(curRoot.right);
    }
}
