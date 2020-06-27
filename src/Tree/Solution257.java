package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/24-8:22
 */
public class Solution257 {
    /*
    给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
     */
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
          ans=new ArrayList<>();
          Stack<Integer> stack=new Stack<>();
          if(root==null){
              return ans;
          }
          back(root,stack);
          return ans;
    }
    private void back(TreeNode cur,Stack<Integer> stack){
        if(cur.left==null&&cur.right==null){//说明这是叶子结点
            StringBuilder s=new StringBuilder();
            for (int i = 0; i <stack.size() ; i++) {
                s.append(stack.get(i)).append("->");
            }
            s.append(cur.val);
            ans.add(s.toString());
            return;
        }
        if(cur.left!=null){
            stack.push(cur.val);
            back(cur.left,stack);
            stack.pop();
        }
        if(cur.right!=null){
            stack.push(cur.val);
            back(cur.right,stack);
            stack.pop();
        }
    }
}
