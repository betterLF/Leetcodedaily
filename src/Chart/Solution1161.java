package Chart;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/18-20:14
 */
public class Solution1161 {
    /*
    给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推
请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     */
     public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxLevelSum(TreeNode root) {
         if(root==null){
             return 0;
         }
        Queue<TreeNode> cur=new ArrayDeque<>();
        PriorityQueue<int []> res=new PriorityQueue<>((arr1,arr2)->arr2[1]-arr1[1]==0?arr1[0]-arr2[0]:arr2[1]-arr1[1] );
         int count=1;
         int count2=0;
         int ceng=1;
         cur.add(root);
         while(!cur.isEmpty()){
             int sum=0;
             int a[]=new int[2];
             a[0]=ceng;
             while(count!=0){
               TreeNode c=cur.poll();
               sum+=c.val;
               count--;
               if(c.left!=null){
                   cur.add(c.left);
                   count2++;
               }
               if(c.right!=null){
                   cur.add(c.right);
                   count2++;
               }
             }
             count=count2;
             count2=0;
             ceng++;
             a[1]=sum;
             res.add(a);
         }
          return res.poll()[0];
    }
    //对方法一的优化,不用优先权队列储存所有层数一一对比，max为最大值，maxLevel为最大值所在层数，动态更新
    public int maxLevelSum2(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> cur=new ArrayDeque<>();
        int count=1;
        int count2=0;
        int ceng=1;
        int max=0;
        int maxLevel=0;
        cur.add(root);
        while(!cur.isEmpty()){
            int sum=0;
            while(count!=0){
                TreeNode c=cur.poll();
                sum+=c.val;
                count--;
                if(c.left!=null){
                    cur.add(c.left);
                    count2++;
                }
                if(c.right!=null){
                    cur.add(c.right);
                    count2++;
                }
            }
            if(max<sum){
                max=sum;
                maxLevel=ceng;
            }
            count=count2;
            count2=0;
            ceng++;

        }
        return maxLevel;
    }
}
