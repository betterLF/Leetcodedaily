package Tree;

/**
 * @authtor liFei
 * @date 2020/7/8-7:22
 */
public class Solution337 {
    /*

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     */
    public int rob(TreeNode root) {
        int[] res= dfs(root);
        return Math.max(res[0],res[1]);
    }
    private int[] dfs(TreeNode node){
        if(node==null){
            int dp[]={0,0};
            return dp;
        }
        int []left=dfs(node.left);//求出左子树偷与不偷得到的最大值
        int []right=dfs(node.right);//求出右子树偷与不偷得到的最大值
        int []dp=new int[2];
        dp[1]=node.val+left[0]+right[0];//左右子树都不偷，偷父节点
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);//偷左右子树
        return dp;
    }
}
