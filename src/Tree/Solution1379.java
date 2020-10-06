package Tree;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/4/11-10:11
 */
public class Solution1379 {
    /*
    给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
    其中，克隆树 cloned 是原始树 original 的一个 副本 。
    请找出在树 cloned 中，与 target 相同 的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，
    其他语言返回节点本身）。
    */
      public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
                Stack<TreeNode> s=new Stack<>();
                 TreeNode cur=cloned;
                 int res=target.val;
                 while(cur!=null||s.size()!=0){
                     while(cur!=null){
                         if(cur.val!=res) {
                             s.push(cur);
                         }else{
                            return cur;
                         }
                         cur=cur.left;
                     }
                     cur=s.pop();
                     cur=cur.right;
                 }
                 return null;
    }
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {//前序
          if(cloned==null){
              return null;
          }
             if(cloned.val==target.val){
                 return cloned;
             }
             TreeNode left= getTargetCopy(original,cloned.left,target);
       if(left!=null){
           return left;
       }
       return getTargetCopy(original, cloned.right, target);
    }

}
