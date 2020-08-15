package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/8/13-6:40
 */
public class Solution515 {
    /*
    您需要在二叉树的每一行中找到最大的值。
     */
    public List<Integer> largestValues(TreeNode root) {
              List<Integer> ans=new ArrayList<>();
              if(root==null){
                  return ans;
              }
              int curCount=1;
              Queue<TreeNode> queue=new ArrayDeque<>();
              queue.add(root);
              while (!queue.isEmpty()){
                  int max=queue.peek().val;
                  int nowCount=0;
                  while (curCount!=0){
                      TreeNode cur=queue.poll();
                      max=Math.max(max,cur.val);
                      if(cur.left!=null){
                          queue.add(cur.left);
                          nowCount++;
                      }
                      if(cur.right!=null){
                          queue.add(cur.right);
                          nowCount++;
                      }
                      curCount--;
                  }
                  ans.add(max);
                  curCount=nowCount;
              }
              return ans;
    }
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        if (level == res.size() + 1) {
            res.add(root.val);
        } else {
            res.set(level -1, Math.max(res.get(level - 1), root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
