package List;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/6/16-8:23
 */
public class Solution138 {
    /*
    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。 
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //hashmap
        public Node copyRandomList(Node head) {
            HashMap<Node,Node> map=new HashMap<>();//key为原结点，value为克隆结点
            Node cur=head;
            while (cur!=null){
                map.put(cur,new Node(cur.val));
                cur=cur.next;
            }
            map.put(null,null);
            for (Node key:map.keySet()){
                if(key==null){
                    continue;
                }
                map.get(key).next=map.get(key.next);//原结点的克隆结点的next域指向原结点next域的克隆结点
                map.get(key).random=map.get(key.random);//原结点的克隆结点的random域指向原结点random域的克隆结点
            }
              return map.get(head);
        }
    public Node copyRandomList2(Node head) {
        if(head==null){
            return null;
        }
         //按照原结点-克隆结点-原结点顺序拼接结点
        Node cur=head;
        while (cur!=null){
            Node temp=cur.next;
            Node clonedNode=new Node(cur.val);
            cur.next=clonedNode;
            clonedNode.next=temp;
            cur=temp;
        }
        //将克隆结点的random域连接好
        cur=head;
        while (cur!=null){
            Node temp=cur.next.next;//保存下一个原结点
            cur.next.random=cur.random==null?null:cur.random.next;//将原结点的random域结点的克隆结点传给克隆结点
            cur=temp;
        }
        //分离两个链表
        cur=head;
        Node ans=cur.next;
        while (cur!=null){
            Node temp=cur.next.next;//保存下一个原结点
            cur.next.next=temp==null?null:temp.next;//将克隆结点的next域指向下一个克隆结点
            cur.next=temp;//将原结点与下一个原结点相连
            cur=temp;
        }
        return ans;
    }
}
