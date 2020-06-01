package Tree;

/**
 * @authtor liFei
 * @date 2020/5/31-9:13
 */
public class Solution111 {
    /*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
     */
    public int minDepth(TreeNode root) {
        return getDepth(root);
    }
    private int getDepth(TreeNode curNode){
        if(curNode==null){
            return 0;
        }
        int m1=getDepth(curNode.left);
        int m2=getDepth(curNode.right);
        return  curNode.left==null||curNode.right==null?m1+m2+1:Math.min(m1,m2)+1;
    }
}
