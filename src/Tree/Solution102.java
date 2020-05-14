package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/5/13-6:57
 */
public class Solution102 {
    /*
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
          Queue<TreeNode> queue=new ArrayDeque<>();//存储每层结点
         if(root==null){
             return ans;
         }
         int count=1;//记录该层节点数
        queue.add(root);
        while (queue.size()!=0){
            List<Integer> temp=new ArrayList<>();
            int cur_count=0;
            while (count!=0){
                TreeNode cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                    cur_count++;
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                    cur_count++;
                }
                count--;
            }
            //结束小的while循环后，得到了下层节点数cur_count并且本层结点全部出队列，下层结点全部入队列
            count=cur_count;//更新下层结点个数
            ans.add(temp);//将本层结点值加入结果集中
        }
        return ans;
    }
}
