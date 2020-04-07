package List;
/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution24ms {
    public ListNode reverseList(ListNode head) {
        ListNode newHead=new ListNode(0);
        ListNode cur=head;
        ListNode next;
        while(cur!=null){
            next=cur.next;//next存储当前结点的下一个结点
            cur.next=newHead.next;//这样使得原链表中cur指向了cur的前一个结点
            newHead.next.next=cur;//把新链表真正意义上的头结点变成cur
            cur=next;//将下一个结点赋值给cur;
        }
        return newHead.next;
    }
}
