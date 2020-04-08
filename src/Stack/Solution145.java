package Stack;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/8-8:56
 */
public class Solution145 {
    /*
    给定一个二叉树，返回它的 后序 遍历。
     */
    //递归
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public  List<Integer> res=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
               if(root==null){
                   return res;
               }
               if(root.left!=null){
                   postorderTraversal(root.left);
               }
               if(root.right!=null){
                   postorderTraversal(root.right);
               }
               res.add(root.val);
               return res;
    }
    //和中序遍历栈法基本相似，但是删掉了树
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            TreeNode r=stack.peek();
            if(r.right==null){
              ans.add(stack.pop().val);
            }else{
                cur=r.right;
                r.right=null;
            }
        }
        return ans;
    }
    //官方解法：dfs遍历+逆序输出
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        if(root==null){
            return ans;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pollLast();
            ans.addFirst(temp.val);
            if(temp.left!=null){
                stack.add(temp.left);
            }
            if(temp.right!=null){
                stack.add(temp.right);
            }
        }
        return ans;
    }
}
