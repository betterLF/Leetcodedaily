package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/2-6:42
 */
public class Solution230 {
    /*
    给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public int kthSmallest(TreeNode root, int k) {
       List<Integer> ans=new ArrayList<>();
       DFS(root,ans);
       return ans.get(k-1);
    }
    private void DFS(TreeNode root, List<Integer> ans){
          if(root==null){
              return;
          }
          DFS(root.left,ans);
          ans.add(root.val);
          DFS(root.right,ans);
    }
    public int value;
      public int cur;
    public int kthSmallest2(TreeNode root, int k) {
        DFS(root,k);
        return value;
    }
    private void DFS(TreeNode root,int k){
        if(root==null){
            return;
        }
        DFS(root.left,k);
           cur++;
            if(cur==k) {
                value = root.val;
                return;
            }
        DFS(root.right,k);
    }
}
