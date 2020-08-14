package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/8/12-7:22
 */
public class Solution513 {
    /*
    给定一个二叉树，在树的最后一行找到最左边的值。
     */
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        int curLeft=-1;
        int curCount=1;
        queue.add(root);
        while (!queue.isEmpty()){
               int nowCount=0;
               curLeft=queue.peek().val;
               while (curCount!=0){
                   curCount--;
                   TreeNode cur=queue.poll();
                   if(cur.left!=null){
                       queue.add(cur.left);
                       nowCount++;
                   }
                   if(cur.left!=null){
                       queue.add(cur.right);
                       nowCount++;
                   }
               }
               curCount=nowCount;
        }
        return curLeft;
    }
}
