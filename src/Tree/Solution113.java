package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/13-7:14
 */
public class Solution113 {
    /*
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
     */
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         ans=new ArrayList<>();
         if(root==null){
             return ans;
         }
         List<Integer> cur=new ArrayList<>();
         cur.add(root.val);
         back(cur,root,sum-root.val);
         return ans;

    }
    private void back(List<Integer> cur,TreeNode root,int sum){
        if(sum==0&&root.left==null&&root.right==null){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(root.left!=null){
            cur.add(root.left.val);
            back(cur,root.left,sum-root.left.val);
            cur.remove(cur.size()-1);
        }
        if(root.right!=null){
            cur.add(root.right.val);
            back(cur,root.right,sum-root.right.val);
            cur.remove(cur.size()-1);
        }
    }
}
