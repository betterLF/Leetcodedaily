package Recursion;

/**
 * @authtor liFei
 * @date 2020/5/23-7:33
 */
/*
二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，
要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
返回转换后的单向链表的头节点。
注意：本题相对原题稍作改动
 */
public class Solution1712ms {
  static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
   }
    TreeNode rootNode;
    public TreeNode convertBiNode1(TreeNode root) {
        //头指针实例化
        rootNode = new TreeNode(0);
        //备份这个头指针
        TreeNode fNode = rootNode;
        xh(root);
        //返回二叉树的第一个节点
        return fNode.right;
    }

    public void xh(TreeNode r) {
        //跳出递归的条件
        if (r == null)
            return;
        //中序遍历
        xh(r.left);
        //将root放入链表最后
        rootNode.right = r;
        //将二叉树中节点原有的left置空
        r.left = null;
        //指向头指针的最后一节点
        rootNode = rootNode.right;
        xh(r.right);
    }

}
