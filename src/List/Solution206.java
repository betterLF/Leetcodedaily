package List;

public class Solution206 {
    /*
    反转一个单链表。
     */
    public ListNode reverseList(ListNode head) {
         ListNode newHead=new ListNode(0);
         ListNode cur=head;
         while(cur!=null){
             ListNode temp=cur.next;
             cur.next=newHead.next;
             newHead.next=cur;
             cur=temp;
         }
         return newHead.next;
    }
}
