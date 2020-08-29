package Tree;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/8/26-6:31
 */
public class Solution653 {
    /*
    给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     */
    private HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
         set=new HashSet<>();
         return infix(root,k);

    }
    private boolean infix(TreeNode cur,int k){
        if(cur==null){
            return false;
        }
        if(infix(cur.left,k)){
            return true;
        }
        if(set.contains(k-cur.val)){
            return true;
        }
        set.add(cur.val);
        if(infix(cur.right,k)){
            return true;
        }
        return false;
    }
}
