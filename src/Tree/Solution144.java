package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/17-8:38
 */
public class Solution144 {
    /*
    给定一个二叉树，返回它的 前序 遍历。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
        //1.递归
        List<Integer> ans;
        public List<Integer> preorderTraversal(TreeNode root) {
               ans=new ArrayList<>();
               inorder(root);
               return ans;
        }
        private void inorder(TreeNode root){
            if(root==null){
                return;
            }
            ans.add(root.val);
            inorder(root.left);
            inorder(root.right);
        }
        //2.迭代(栈)
        public List<Integer> preorderTraversal2(TreeNode root) {
            ans=new ArrayList<>();
           Stack<TreeNode> stack=new Stack<>();
            if(root==null){
                return ans;
            }
            stack.push(root);
            while (stack.size()!=0){
                TreeNode temp=stack.pop();
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }
                ans.add(temp.val);
            }
            return ans;
        }
    }
}
