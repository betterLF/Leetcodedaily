package Tree;

/**
 * @authtor liFei
 * @date 2020/5/29-6:41
 */
public class Solution100 {
    /*
    给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */
      public class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public boolean flag;
    public boolean isSameTree(TreeNode p, TreeNode q) {
                flag=true;
              if(p==null&&q==null){
                  return true;
              }else if(p!=null&&q==null||p==null&&q!=null){
                  return false;
              }else{
                  isSame(p,q);
                  return flag;
              }
    }
    private void isSame(TreeNode p,TreeNode q){
        if(flag==false){
            return;
        }
          if(p.val!=q.val){
             flag=false;
          }else if((p.left!=null&&q.left==null||p.left==null&&q.left!=null)||(p.right!=null&&q.right==null||p.right==null&&q.right!=null)){
              flag=false;
          }
            if(p.left!=null) {
                isSame(p.left, q.left);
            }
        if(p.right!=null) {
            isSame(p.right, q.right);
        }

    }
}
