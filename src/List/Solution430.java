package List;

/**
 * @authtor liFei
 * @date 2020/7/25-5:50
 */
public class Solution430 {
    /*
    多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
    这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
     */
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        Node cur=new Node();
        cur.next=head;
               dfs(cur);
               return head;
    }
    private Node dfs(Node curNode){
        if(curNode==null){
            return null;
        }
        while (curNode.next!=null){
            if(curNode.next.child!=null){//如果该结点存在孩子结点
               Node top=curNode.next.next;//保存该结点的下一个结点
                if(top!=null) {//如果该结点不为null，就断开联系
                    top.prev = null;
                    curNode.next.next = null;
                }
                curNode.next.next=curNode.next.child;//将当前结点的next域指向孩子结点
                curNode.next.child.prev=curNode.next;//将孩子结点的prev域指向当前结点
                curNode.next.child=null;//当前结点的孩子域置为null
                Node dfs = dfs(curNode.next);//得到该轮dfs得到的末尾结点
                if(top!=null){
                    dfs.next=top;
                    top.prev=dfs;
                    curNode=top;
                }else{//到达末尾，直接返回
                    break;
                }
            }else{//如果该结点不存在孩子结点，直接后移
                curNode=curNode.next;
            }
        }
        return curNode;
    }
}
