package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/5/30-6:52
 */
public class Solution107 {
    /*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    public class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
             List<List<Integer>> ans=new LinkedList<>();
              if(root==null){
                  return ans;
              }
        Queue<TreeNode> q=new ArrayDeque();
              q.add(root);
              int count=1;
              while (q.size()!=0){
                  List<Integer> cur=new ArrayList<>();
                  int nextCount=0;
                  while (count!=0){
                      TreeNode curNode=q.poll();
                      if(curNode.left!=null){
                          q.add(curNode.left);
                          nextCount++;
                      }
                      if(curNode.right!=null){
                          q.add(curNode.right);
                          nextCount++;
                      }
                      cur.add(curNode.val);
                      count--;
                  }
                  count=nextCount;
                  ans.add(0,cur);
              }
              return ans;
    }
}
