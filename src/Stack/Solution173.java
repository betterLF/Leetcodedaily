package Stack;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/4/7-16:06
 */
/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class Solution173 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
        TreeNode(int x) { val = x; }
     }

    class BSTIterator {
         private TreeNode ans;
         private int count;
         private int num;
         private ArrayList<Integer> arr;
        public BSTIterator(TreeNode root) {
            ans=root;
            arr=new ArrayList<>();
            count=0;
            num=0;
            mid(ans);
        }
        public void mid(TreeNode node){
            if(node==null){
                return;
            }
            if(node.left!=null){
                mid(node.left);
            }
            arr.add(node.val);
            count++;
            if(node.right!=null){
                mid(node.right);
            }
        }
        public int next() {
          return arr.get(num++);
        }


        public boolean hasNext() {
         if(num<count){
             return true;
         }
         return false;
        }
    }
}
