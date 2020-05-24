package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/22-8:00
 */
public class Solution589
{
    /*
    给定一个 N 叉树，返回其节点值的前序遍历。
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //递归实现
    public List<Integer> preorder(Node root) {
         List<Integer> ans=new ArrayList<>();
             preorder(root,ans);
             return ans;
    }
    private void preorder(Node curroot,List<Integer> ans){
        if(curroot==null){
            return;
        }
        ans.add(curroot.val);
        for (int i = 0; i <curroot.children.size() ; i++) {
            preorder(curroot.children.get(i),ans);
        }
    }
    //迭代
    public List<Integer> preorder2(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }
            stack.add(root);//将首结点加入栈中
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.add(node.val);//将当前结果加入结果集
                Collections.reverse(node.children);//翻转链表，加入栈中，使得每次取出的第一个都是最左的结点
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
            return output;
        }
    }

