package Tree;

import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/4/13-8:10
 */
public class Solution938 {
    /*
    给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
    二叉搜索树保证具有唯一的值。
*/
   public class TreeNode {
      int val;
      TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
    public int sum=0;
   public  int left=0;
   public int right=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
         left=L;
         right=R;
         infix(root);//解法一
          DFS(root);//解法二
         return sum;
    }
    //解法一，不管二叉搜索树的性质，直接中序遍历
    private void infix(TreeNode root){
       if(root==null){
           return;
       }
       if(root.left!=null){
           infix(root.left);
       }
       if(judge(root.val)){
           sum+=root.val;
       }
       if(root.right!=null){
           infix(root.right);
       }
    }
    private boolean judge(int num){
        return num>=left&&num<=right?true:false;
    }
    //解法二，按照二叉搜索树的性质减少遍历
    private void DFS(TreeNode root){
        if(root==null){
            return;
        }
        if(depend(root.val)==0){
            sum+=root.val;
            DFS(root.left);
            DFS((root.right));
        }else if(depend(root.val)==1){
            DFS(root.right);
        }else{
            DFS(root.left);
        }

    }
    private int depend(int num){
        if(num>=left&&num<=right){
            return 0;
        }else if(num<left){
            return 1;
        }else {
            return 2;
        }
    }
}
