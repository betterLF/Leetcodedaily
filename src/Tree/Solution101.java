package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/5/30-6:18
 */
public class Solution101 {
    /*
    给定一个二叉树，检查它是否是镜像对称的。
    */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isSymmetric(TreeNode root) {
          return isMirror(root,root);
    }
    //递归
    private boolean isMirror(TreeNode t1,TreeNode t2){
            if(t1==null&&t2==null){
                return true;
            }else if(t1!=null&&t2!=null){
                return (t1.val==t2.val)&&isMirror(t1.right,t2.left)&&isMirror(t1.left,t2.right);
            }else {
                return false;
            }
    }
    //迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(root);
        while (q.size()!=0){
            TreeNode q1=q.poll();
            TreeNode q2=q.poll();
            if(q1==null&&q2==null){
                continue;
            }else if(q1==null||q2==null){
                return false;
            }
            if(q1.val!=q2.val){
                return false;
            }else{
                q.add(q1.left);
                q.add(q2.right);
                q.add(q1.right);
                q.add(q2.left);
            }
        }
        return true;
    }
}
