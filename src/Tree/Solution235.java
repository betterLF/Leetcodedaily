package Tree;

/**
 * @authtor liFei
 * @date 2020/6/24-8:13
 */
public class Solution235 {
    /*
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                int min=Math.min(p.val,q.val);
                int max=Math.max(p.val,q.val);
                TreeNode cur=root;
                     while (true){
                         if(cur.val>min&&cur.val<max){//说明两个结点一个在该结点左边，一个在右边
                          break;//cur就是结果
                         }else if(cur.val<min){//说明两个结点都在当前结点右边
                             cur=cur.right;
                         }else if(cur.val>max){//说明两个结点都在当前结点左边
                             cur=cur.left;
                         }else{//当前结点和其中一个相等
                             break;
                         }
                     }
                     return cur;
    }
}
