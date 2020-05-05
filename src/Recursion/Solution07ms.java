package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/5/4-6:56
 */
public class Solution07ms {
    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);//将中序遍历的元素和下标存入hashmap中
            }
            return build(preorder,0, 0, inorder.length - 1);
        }

        private TreeNode build(int preOrder[],int preStart, int inLeft, int inRight) {
            if(inLeft > inRight) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[preStart]);
            int order = map.get(preOrder[preStart]);
            root.left = build( preOrder,preStart+1,inLeft, order - 1);//当前结点的左子树索引必然是其下一个元素
            root.right = build( preOrder,preStart+order-inLeft+1,order + 1, inRight);//当前结点的右子树索引是
            // 当前结点+其左子树长度+1
            return root;
        }
        HashMap<Integer,Integer> cur=new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
           if(preorder.length==0){
               return null;
           }
           int len=preorder.length;
        for (int i = 0; i <len ; i++) {
            cur.put(inorder[i],i);//存放中序遍历的结点值和索引
        }
           return build2(preorder,0,0,len-1);
    }
    private TreeNode build2(int preorder[],int start,int left,int right){
            if(left>right){//如果该子区间不存在
                return null;
            }
            TreeNode root=new TreeNode(preorder[start]);
            int next=cur.get(preorder[start]);//获取当前首元素在中序遍历中的位置，划分左右子树区间
           root.left=build2(preorder,start+1,left,next-1);
           root.right=build2(preorder,start+next-left+1,next+1,right);
           return root;

    }
}
