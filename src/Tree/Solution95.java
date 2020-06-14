package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/12-7:45
 */
public class Solution95 {
    /*
    给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }else {
            return back(1, n);
        }
    }

    private LinkedList<TreeNode> back(int start, int end) {
        if(start>end){
            LinkedList<TreeNode> cur=new LinkedList<>();
            cur.add(null);
            return cur;
            //return new LinkedList<>();//不能写成这样，不然选择左右子树的for循环有一个会因此不进行，导致拼接左右子树不能进行
        }
        LinkedList<TreeNode> c = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left = back(start, i - 1);
            LinkedList<TreeNode> right = back(i + 1, end);
            for (TreeNode curLeft : left) {
                for (TreeNode curRight : right) {
                    TreeNode head = new TreeNode(i);
                    head.left = curLeft;
                    head.right = curRight;
                    c.add(head);
                }
            }

        }
        return c;
    }
}

