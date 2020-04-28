package HashTable;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/4/27-8:47
 */
public class Solution1261 {
    /*
    给出一个满足下述规则的二叉树：
root.val == 0
如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
请你先还原二叉树，然后实现 FindElements 类：
FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
     */
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
 }
    class FindElements {
        HashSet<Integer> ans=new HashSet<>();
        public FindElements(TreeNode root) {
            root.val=0;
            pre(root);
        }
        public boolean find(int target) {
                if(ans.contains(target)){
                    return true;
                }
                return false;
        }
        private void pre(TreeNode cur){
            ans.add(cur.val);
            if(cur.left!=null){
                cur.left.val=2*cur.val+1;
                pre(cur.left);
            }
            if(cur.right!=null){
                cur.right.val=2*cur.val+2;
                pre(cur.right);
            }
        }
    }
}
