package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/13-7:06
 */
public class Solution1302 {
    /*
    给你一棵二叉树，请你返回层数最深的叶子节点的和。
     */
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //解法一：依次层次遍历
    public  int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int sum=0;
        if (root== null) {
            return 0;
        } else {
            TreeNode cur = root;
            queue.add(cur);
        }
        while (true) {
            int count = queue.size();
           TreeNode curNow = queue.poll();
            List<Integer> c=new ArrayList<>();
             c.add(curNow.val);
            while (count != 0) {
                if (curNow.left != null) {
                    queue.add(curNow.left);
                }
                if (curNow.right != null) {
                    queue.add(curNow.right);
                }
                if(count!=1) {
                    curNow = queue.poll();
                    c.add(curNow.val);
                }
                    count--;
            }
            if(queue.isEmpty()){
                int count2=c.size()-1;
                while (count2>=0){
                    sum+=c.get(count2);
                    count2--;
                }
                break;
            }
        }
        return sum;
    }
    //解法二：动态更新
    public int deep=1;
    public int sum=0;
    public  int deepestLeavesSum2(TreeNode root) {
        searchDeepest(root,1);
        return sum;
    }
private void searchDeepest(TreeNode root,int curDeep){
        if(root==null){
            return;
        }
        if(curDeep==deep){
            sum+=root.val;
        }
        if(curDeep>deep){
            sum=0;
            deep=curDeep;
            sum+=root.val;
        }
        searchDeepest(root.left,curDeep+1);
        searchDeepest(root.right,curDeep+1);
}
}
