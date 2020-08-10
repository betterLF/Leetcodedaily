package Tree;

/**
 * @authtor liFei
 * @date 2020/8/8-7:42
 */
public class Solution563 {
    /*
    给定一个二叉树，计算整个树的坡度。
一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
整个树的坡度就是其所有节点的坡度之和。
     */
    public int ans;
    public int findTilt(TreeNode root) {
       ans=0;
       dfs(root);
       return ans;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int L=dfs(root.left);
        int R=dfs(root.right);
        int curAns=Math.abs(L-R);
        ans+=curAns;
        return root.val+L+R;
    }
}
