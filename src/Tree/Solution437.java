package Tree;

/**
 * @authtor liFei
 * @date 2020/7/18-7:21
 */
public class Solution437 {
    /*
    给定一个二叉树，它的每个结点都存放着一个整数值。
    找出路径和等于给定数值的路径总数。
    路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
    */
    public int ans;
    public int pathSum(TreeNode root, int sum) {
        ans=0;
        dfs(root,new int[1000],0,sum);
        return ans;
    }

    /**
     *
     * @param root 当前遍历到的结点
     * @param num   存放遍历到当前结点走过的值
     * @param curIndex  //当前结点的层数
     */
    private void dfs(TreeNode root,int[]num,int curIndex,int sum){
        if(root==null){
            return;
        }
        num[curIndex]=root.val;
        int temp=0;
        for (int i = curIndex; i>=0 ; i--) {
            temp+=num[i];
            if(temp==sum){
                ans++;
            }
        }
        dfs(root.left,num,curIndex+1,sum);
        dfs(root.right,num,curIndex+1,sum);

    }

}
