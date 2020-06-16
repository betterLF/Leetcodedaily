package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/6/14-8:13
 */
public class Solution116 {
    /*
    给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()){
            int nextCount=0;
            while (count!=0){
                Node temp=queue.poll();
                if(count!=1){//如果不是该层最后一个
                    temp.next=queue.peek();
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                    nextCount++;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    nextCount++;
                }
                count--;
            }
            count=nextCount;
        }
           return root;
    }
    public Node connect2(Node root) {
        if(root==null||root.left==null){
            return root;
        }
        Node preNode=root;
        Node nowNode=root.left;
        while (nowNode!=null) {//如果子节点不为空
                Node curNode=preNode;
                while (curNode!=null) {
                    curNode.left.next = curNode.right;//同一父节点下的拼接
                    if(curNode.next!=null) {
                        curNode.right.next = curNode.next.left;//相邻两个子树之间拼接
                    }
                    curNode=curNode.next;
                }
                preNode=nowNode;
            nowNode=nowNode.left;//进行下一层
            }
        return root;
    }
}
