package BinarySearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/5/2-7:16
 */
public class Solution222 {
    /*
    完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
       int row=0;
       int number=0;
       int ans=0;
       boolean flag=false;
        Queue<TreeNode> Q=new ArrayDeque<TreeNode>();
        if(root==null){
            return 0;
        }else{
            Q.add(root);
            row++;
            number=1;
        }
        while (true){
            int temp=0;//记录下层节点数
            while (number!=0){//当层节点数
                TreeNode cur=Q.poll();
                number--;
                if(cur.left!=null&&cur.right!=null){
                        Q.add(cur.left);
                        Q.add(cur.right);
                        temp+=2;
                }else{
                    flag=true;//说明当前为叶子结点
                    if(cur.left!=null){
                        Q.add(cur.left);
                        temp++;
                    }
                    if(cur.right!=null){
                        Q.add(cur.right);
                        temp++;
                    }
                }
            }
            if(flag==true||temp==0){
                ans=(int)Math.pow(2,row)-1+temp;
               break;
            }
            number=temp;
            row++;
        }
        return ans;
    }
    public int countNodes2(TreeNode root) {
        return root==null?0:countNodes2(root.left)+countNodes2(root.right)+1;
    }
}
