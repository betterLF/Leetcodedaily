package Tree;

/**
 * @authtor liFei
 * @date 2020/8/10-7:17
 */
public class Solution572 {
    /*
    给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     */


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
        public boolean isSubtree(TreeNode s, TreeNode t) {
          if(s==null){
              return false;
          }
          if(s.val==t.val){
              if(isSame(s,t)){
                 return true;
              }
          }
          return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    private boolean isSame(TreeNode cur,TreeNode t){
             if(cur==null&&t!=null||cur!=null&&t==null){
                 return false;
             }
             if(cur==null&&t==null){
                 return true;
             }
             if(cur.val==t.val){
                 return isSame(cur.left,t.left)&&isSame(cur.right,t.right);
             }else{
                 return false;
             }
    }
}
