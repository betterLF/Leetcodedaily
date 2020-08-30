package Tree;

/**
 * @authtor liFei
 * @date 2020/8/28-9:51
 */
public class Solution687 {
    /*
    给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。
     */
    private int max;
    public int longestUnivaluePath(TreeNode root) {
       max=0;
       getLength(root);
       return max;
    }
    private int getLength(TreeNode cur){
        if(cur==null){
            return 0;
        }
        int val=cur.val;
        int left=getLength(cur.left);
        int right=getLength(cur.right);
        int leftAns=0;
        int rightAns=0;
        if(cur.left!=null&&cur.left.val==val) {
          leftAns+=left+1;
        }
        if(cur.right!=null&&cur.right.val==val){
          rightAns+=right+1;
        }
        max=Math.max(max,leftAns+rightAns);
        return Math.max(leftAns,rightAns);
    }
}
