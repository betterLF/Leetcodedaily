package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/8/25-7:26
 */
public class Solution637 {
    /*
    给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     */
    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> ans=new ArrayList<>();
       if(root==null){
           return ans;
       }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()){
            int temp=count;
            int curCount=0;
            double curAns=0;
            while (count!=0){
                TreeNode c=queue.poll();
                curAns+=c.val;
                if(c.left!=null){
                    curCount++;
                    queue.add(c.left);
                }
                if(c.right!=null){
                    curCount++;
                    queue.add(c.right);
                }
                count--;
            }
            ans.add(curAns/temp);
            count=curCount;
        }
        return ans;
    }
}
