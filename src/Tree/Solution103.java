package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/13-6:37
 */
public class Solution103 {
    /*
    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    List<List<Integer>> ans;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        Stack<TreeNode> stack=new Stack<>();
        boolean flag=false;//用于判断是从栈还是队列中拿元素
        queue.add(root);
             while (queue.size()!=0||stack.size()!=0){
                 List<Integer> cur=new LinkedList<>();
                 if(flag==false){//从队列中取出元素，并依次放入栈中
                     while (queue.size()!=0){
                         TreeNode curNode=queue.remove();
                         if(curNode.left!=null){
                             stack.add(curNode.left);
                         }
                         if(curNode.right!=null){
                             stack.add(curNode.right);
                         }
                         cur.add(curNode.val);
                     }
                     ans.add(cur);
                     flag=true;
                 }else{//从栈中取出元素，并依次放入队列中
                     for (int i=0;i<stack.size();i++) {
                         TreeNode curNode = stack.get(i);
                         if (curNode.right != null) {
                             queue.add(curNode.right);
                         }
                         if (curNode.left != null) {
                             queue.add(curNode.left);
                         }
                     }
                  while (stack.size()!=0){
                      cur.add(stack.pop().val);
                  }
                     ans.add(cur);
                     flag=false;
                 }
             }
             return ans;
    }
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (null == root) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> newQueue = new LinkedList();
            List<Integer> subResult = new ArrayList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollLast();
                subResult.add(node.val);
                if (flag) {//如果是左->右，按左右顺序存放进newQueue，这样从后往前取就是下一层结果
                    if (node.left != null) {
                        newQueue.add(node.left);
                    }

                    if (node.right != null) {
                        newQueue.add(node.right);
                    }
                } else {//如果是右-左，按右左顺序存放进newQueue，这样从后往前取就是下一层结果
                    if (node.right != null) {
                        newQueue.add(node.right);
                    }
                    if (node.left != null) {
                        newQueue.add(node.left);
                    }
                }
            }

            flag = !flag;
            result.add(subResult);
            queue = newQueue;
        }

        return result;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        dfs(root, 0);//从第0层开始
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {//如果当层没有元素加入结果集，就新建该层
            res.add(new ArrayList<>());
        }

        if ((level & 1) == 0) {//如果是从左->右
            res.get(level).add(root.val);//依次加入结果
        } else {
            res.get(level).add(0, root.val);//倒序加入结果
        }

        dfs(root.left, level + 1);//进行下一层遍历
        dfs(root.right, level + 1);
    }
}
