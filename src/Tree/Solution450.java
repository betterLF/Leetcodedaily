package Tree;

/**
 * @authtor liFei
 * @date 2020/7/28-7:04
 */
public class Solution450 {
    /*
    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
    并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：
首先找到需要删除的节点；
如果找到了，删除它。
     */
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode deleteNode(TreeNode root, int key) {
      if(root==null){
        return null;
      }
         if(root.val==key){
           if(root.left==null){
             return root.right;
           }
           if(root.right==null){
             return root.left;
           }
           TreeNode left=root.left;
           TreeNode right=root.right;
           while (left.right!=null){//找到最后一个右节点
             left=left.right;
           }
           left.right=right;
            TreeNode ans=root.left;
            root.left=null;//删除结点
            root.right=null;
            return ans;
         }else{
           dfs(root,root,key);
             return root;
         }
    }
    private void dfs(TreeNode curNode ,TreeNode preNode ,int key){
        if(curNode==null) {
          return;
        }
        if(curNode.val<key){
          dfs(curNode.right,curNode,key);
          return;
        }else if(curNode.val>key){
          dfs(curNode.left,curNode,key);
          return;
        }
        //删除该结点
       TreeNode left=curNode.left;
       TreeNode right=curNode.right;
        if(left==null){//如果左结点不存在
          if(preNode.left==curNode){
            preNode.left=right;
          }else{
            preNode.right=right;
          }
          return;
        }
      if(right==null){//如果右结点不存在
        if(preNode.left==curNode){
          preNode.left=left;
        }else{
          preNode.right=left;
        }
        return;
      }
      //如果两个结点都存在，就将该右结点放到左节点最后一个右节点处
      if(preNode.left==curNode){//将左结点和要删除结点的父节点联系起来
        preNode.left=left;
      }else{
        preNode.right=left;
      }
      while (left.right!=null){//找到最后一个右节点
        left=left.right;
      }
      left.right=right;
      return;
    }
}
