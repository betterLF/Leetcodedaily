package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/29-8:32
 */
public class Solution236 {
    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     */
    List<TreeNode> pp;
    List<TreeNode> qq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        LinkedList<TreeNode> Parent=new LinkedList<>();
         pp=new ArrayList<>();
         qq=new ArrayList<>();
         dfs(Parent,root,p,q,0);
        for (int i = 0; i <pp.size() ; i++) {
            System.out.println(pp.get(i).val);
        }
        for (int i = pp.size()-1; i>=0 ; i--) {
            if(qq.contains(pp.get(i))){
                return pp.get(i);
            }
        }
        return null;

    }
    private void dfs(LinkedList<TreeNode> stack, TreeNode cur, TreeNode p, TreeNode q, int count){
        if(cur==null||count==2){
            return;
        }
        if(cur==p){
            stack.addLast(p);
            pp=new ArrayList<>(stack);
            stack.removeLast();
            count++;
        }
        if(cur==q){
            stack.addLast(q);
            qq=new ArrayList<>(stack);
            stack.removeLast();
            count++;
        }
        stack.addLast(cur);
        dfs(stack,cur.left,p,q,count);
        dfs(stack,cur.right,p,q,count);
        stack.removeLast();
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);//找到当前根节点左边是否存在p或者q
        TreeNode right = lowestCommonAncestor2(root.right, p, q);//找到当前根节点右边是否存在p或者q
        if (left == null) {//如果左边没找到，说明都在右边
            return right;
        }
        if (right == null) {//如果右边没找到，说明都在左边
            return left;
        }
        return root;//如果左右都找到，说明两个异侧，根节点为其父节点
    }
}
