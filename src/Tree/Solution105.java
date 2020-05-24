package Tree;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/22-6:23
 */
public class Solution105 {
    /*
根据一棵树的前序遍历与中序遍历构造二叉树。
 */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          HashMap<Integer,Integer> temp=new HashMap<>();
        for (int i = 0; i <inorder.length ; i++) {
            temp.put(inorder[i],i);
        }
                return buildChildTrue(preorder,0,0,preorder.length-1,temp);
    }
    private TreeNode buildChildTrue(int []preorder, int start,int left,int right, HashMap<Integer,Integer> temp){
                         if(left>right){
                            return null;
                          }
                          TreeNode cur=new TreeNode(preorder[start]);
                          int leftLength=temp.get(preorder[start]);
                          cur.left=buildChildTrue(preorder,start+1,left,leftLength-1,temp);
                          //leftLength-left  左子树长度
                          cur.right=buildChildTrue(preorder,start+leftLength-left+1,leftLength+1,right,temp);
                          return cur;
    }
}
