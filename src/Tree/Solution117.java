package Tree;

/**
 * @authtor liFei
 * @date 2020/6/14-8:39
 */
public class Solution117 {
    /*
    给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
     */
    static class Node {
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

    public static void main(String[] args) {
        //[1,null,-9,null,8,4,-3,null,null,-3,null,-6,null,null,-6,-4,-9,null,null,6]
        Node head=new Node(1);
        head.right=new Node(-9);
        head.right.right=new Node(8);
        head.right.right.left=new Node(4);
        head.right.right.right=new Node(3);
        head.right.right.right.left=new Node(-3);
        connect(head);
        System.out.println("aa");

    }
    public static Node connect(Node root) {
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        Node preNode=root;
        Node nowNode=new Node(0);
        if(root.left!=null) {
        nowNode = root.left;
        }else{
        nowNode=root.right;
        }
        while (nowNode!=null) {//如果子节点不为空
            Node curNode=preNode;
            Node cNode=nowNode;
            if(curNode.left!=null&&curNode.right!=null){//将该子树拼接好，使得cNode的next域指向下一个不同的子树
                cNode.next=curNode.right;
                cNode=cNode.next;
            }
            curNode=curNode.next;
            while (curNode!=null) {
              if(curNode.left!=null&&curNode.right!=null){//如果当层结点的左右子结点都存在，就将两个next域都赋值好，cNode指向最后
                  cNode.next=curNode.left;
                  cNode=cNode.next;
                  cNode.next=curNode.right;
                  cNode=cNode.next;
                  curNode=curNode.next;
              }else if(curNode.left==null&&curNode.right==null){//如果当层结点的左右子树都为空，后移，继续找下一个子节点存在的
                  curNode=curNode.next;
              }else{
                  if(curNode.left!=null){
                      cNode.next=curNode.left;
                  }else{
                      cNode.next=curNode.right;
                  }
                  cNode=cNode.next;
                  curNode=curNode.next;
              }
            }
            while (nowNode!=null&&nowNode.left==null&&nowNode.right==null){//找到一个子节点不为空的当层结点作为preNode
                nowNode=nowNode.next;
            }
            if(nowNode==null){//说明下一层没有结点存在，直接退出
                break;
            }
            preNode=nowNode;
            if(preNode.left!=null){//下一层出发的结点
                nowNode=preNode.left;
            }else{
                nowNode=preNode.right;
            }
        }
        return root;
    }
}
