package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution35ms {
    /*
    请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
    每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     */
    static class  Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        //自己写的成就感
        public Node copyRandomList(Node head) {
            if (head == null) {//如果为空链表就返回null
                return null;
            }
            Node cur = head;
            while (cur != null) {//将每个原结点后添加一个新的复制结点，新的复制结点的next指向下一个原结点，
                // random均指向一个new的val为0的结点
                Node turn = cur.next;
                Node newH = new Node(0);
                newH.val = cur.val;
                newH.random = new Node(0);
                cur.next = newH;
                newH.next = turn;
                cur = turn;
            }
            cur = head;
            while (cur != null) {//将复制结点的random域指向正确的位置
                cur.next.random = cur.random == null ? null : cur.random.next;
                cur = cur.next.next;
            }
            cur = head;
            Node newHand = new Node(0);
            newHand.next = cur.next;//指向第一个复制结点
            while (cur != null) {//指的是原结点
                if (cur.next.next != null) {//这里的cur.next.next指的都是原结点
                    Node tem = cur.next.next;//存储下一个原结点位置
                    cur.next.next = cur.next.next.next;//将上一个复制结点的next域指向下一个复制结点
                    cur.next = tem;//原结点指向下一个原结点
                    cur = cur.next;//原结点后移
                } else {//如果原结点到达最后，就将原结点的next域置null
                    cur.next = cur.next.next;
                    break;
                }
            }
            return newHand.next;
        }

        //哈希表：key值表示原结点，value值表示复制结点，与上面效率一样
        public static Node copyRandomList2(Node head) {
            HashMap<Node, Node> res = new HashMap<>();
            Node p = head;
            while (p != null) {
                res.put(p, new Node(p.val));
                p = p.next;
            }
            p = head;
            while (p != null) {
                res.get(p).next = res.get(p.next);
                res.get(p).random = res.get(p.random);
                p = p.next;
            }
            return res.get(head);
        }
    }
}
