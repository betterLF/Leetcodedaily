package Tree;

/**
 * @authtor liFei
 * @date 2020/9/10-8:24
 */
public class Solution623 {
    /*
    给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
         if(d==1){
             TreeNode ans=new TreeNode(v);
             ans.left=root;
             return ans;
         }
            dfs(root,1,d,v);
         return root;
    }
    private void dfs(TreeNode root,int curDepth,int target,int val){
        if(curDepth==target-1){
            TreeNode left=root.left;
            root.left=new TreeNode(val);
            root.left.left=left;
            TreeNode right=root.right;
            root.right=new TreeNode(val);
            root.right.right=right;
            return;
        }
        if(root.left!=null){
            dfs(root.left, curDepth+1, target, val);
        }
        if(root.right!=null){
            dfs(root.right, curDepth+1, target, val);
        }
    }
}
