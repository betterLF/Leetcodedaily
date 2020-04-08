package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/8-7:57
 */
public class Solution94 {
    /*
    给定一个二叉树，返回它的中序遍历。
     */
      public static class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode s=new TreeNode(1);
         s.right=new TreeNode(2);
         s.right.left=new TreeNode(3);
         inorderTraversal2(s);
    }
  //1:递归
    public  List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return res;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return res;
    }
    //2:迭代(基于栈，官方版）
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur= stack.pop();
            ans.add(cur.val);
            cur=cur.right;
        }
        return ans;
    }

}
