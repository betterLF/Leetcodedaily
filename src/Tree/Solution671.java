package Tree;

/**
 * @authtor liFei
 * @date 2020/8/27-6:30
 */
public class Solution671 {
    /*
    给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
    如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     */
//    private PriorityQueue<Integer> priorityQueue;
//    public int findSecondMinimumValue(TreeNode root) {
//      priorityQueue=new PriorityQueue<>();
//         if(root==null){
//             return -1;
//         }
//         dfs(root);
//         int min=priorityQueue.poll();
//         while (!priorityQueue.isEmpty()){
//             int cur=priorityQueue.poll();
//             if(cur>min){
//                 return cur;
//             }
//         }
//         return -1;
//    }
//    private void dfs(TreeNode cur){
//       if(cur==null){
//           return;
//       }
//       if(cur.left!=null) {
//           int curAns = Math.min(cur.left.val, cur.right.val);
//           priorityQueue.add(curAns);
//           dfs(cur.left);
//           dfs(cur.right);
//       }else{
//         priorityQueue.add(cur.val);
//       }
//    }
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
