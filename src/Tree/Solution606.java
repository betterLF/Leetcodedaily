package Tree;

/**
 * @authtor liFei
 * @date 2020/8/24-6:41
 */
public class Solution606 {
    /*
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     */
    private StringBuilder ans;
    public String tree2str(TreeNode t) {
            ans=new StringBuilder();
            preorder(t);
            return ans.toString();
    }
    private void preorder(TreeNode t){
        if(t==null){
            return;
        }
        ans.append(t.val);
        if(t.left==null&&t.right==null){
            return;
        }
        ans.append("(");
        preorder(t.left);
        ans.append(")");
        if(t.right==null){
            return;
        }
        ans.append("(");
        preorder(t.right);
        ans.append(")");
    }
}
