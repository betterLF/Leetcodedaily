package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/4-6:01
 */
public class Solution894 {
    /*
    满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
答案中每个树的每个结点都必须有 node.val=0。
你可以按任何顺序返回树的最终列表。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        if ((N & 1) == 0)//N为偶数不可能满二叉树
            return new ArrayList<>(0);
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {//N为1返回当前节点
            list.add(new TreeNode(0));
            return list;
        }
        --N;//N的值应减一，因为去掉了根节点
        for (int i = 1; i < N; i += 2) {//i为N重分给左节点的节点数，每次加2因为每次向下分配都要多两个节点
            List<TreeNode> left = allPossibleFBT(i);//这里list存着分配i个节点后的左节点的所有情况list
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {//双重循环，分别把左右节点的各种情况赋予根节点的左右节点，并存储
                    TreeNode root = new TreeNode(0);
                    root.left = nodeL;
                    root.right = nodeR;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public List<TreeNode> allPossibleFBT2(int N) {
        if (N % 2 == 0) {//为偶数不可能是满二叉树
            return new ArrayList<>(0);
        }
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            ans.add(root);
            return ans;
        }
        N--;//减去根节点
        for (int i = 1; i < N; i+=2) {
            List<TreeNode> rootLeft = allPossibleFBT(i);//所有根节点左子树的取值
            List<TreeNode> rootRight = allPossibleFBT(N - i);
            for (TreeNode left : rootLeft) {
                for (TreeNode right : rootRight) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}

