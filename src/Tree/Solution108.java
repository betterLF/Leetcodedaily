package Tree;

/**
 * @authtor liFei
 * @date 2020/5/30-7:32
 */
public class Solution108 {
    /*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
          return createTree(nums,0,nums.length);
    }
    private TreeNode createTree(int []nums,int start,int end){
        if(start>end){
            return null;
        }else{
            int mid=(start+end)/2;
            TreeNode cur=new TreeNode(nums[mid]);
            cur.left=createTree(nums,start,mid);
            cur.right=createTree(nums,mid+1,end);
            return cur;
        }
    }
}
