package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/14-16:34
 */
public class Solution129 {
    /*

给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。
     */
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
   List<String> ans;
    public int sumNumbers(TreeNode root) {
          if(root==null){
              return 0;
          }
          ans=new ArrayList<>();
          Stack<Integer> stack=new Stack<>();
          dfs(root,stack);
          int ansAll=0;
        for (int i = 0; i <ans.size() ; i++) {
            ansAll+=Integer.parseInt(ans.get(i));
        }
        return ansAll;
    }
    private void dfs(TreeNode root, Stack<Integer> stack){
                 stack.push(root.val);
                if(root.left==null&&root.right==null){//到达叶子结点
                    StringBuilder cur=new StringBuilder();
                    for (int i = 0; i <stack.size() ; i++) {
                        cur.append(stack.get(i));
                    }
                    ans.add(cur.toString());
                    stack.pop();
                    return;
                }
                if(root.left!=null) {
                    dfs(root.left, stack);
                }
                if(root.right!=null) {
                    dfs(root.right, stack);
                }
            stack.pop();
    }
    public int sumNumbers2(TreeNode root) {
        if(root==null){
            return 0;
        }
         return Sum(root,0);
    }
    private int Sum(TreeNode root,int temp){
        if(root==null) {//如果当前结点为空，直接返回0
            return 0;
        }
        temp=10*temp+root.val;
        if(root.left==null&&root.right==null){//如果当前结点为叶子结点，直接返回该值
            return temp;
        }
        return Sum(root.left,temp)+Sum(root.right,temp);//返回该结点左右子树和
    }
}
