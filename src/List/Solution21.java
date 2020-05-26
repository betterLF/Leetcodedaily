package List;

/**
 * @authtor liFei
 * @date 2020/5/25-7:32
 */
public class Solution21 {
    /*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
               ListNode head=new ListNode(0);
               ListNode cur1=l1;
               ListNode cur2=l2;
               ListNode cur=head;
               while (cur1!=null&&cur2!=null){
                   if(cur1.val<cur2.val){
                       cur.next=cur1;
                       cur1=cur1.next;
                   }else{
                       cur.next=cur2;
                       cur2=cur2.next;
                   }
                   cur=cur.next;
               }
               if(cur1==null){
                   cur.next=cur2;
               }else{
                   cur.next=cur1;
               }
               return head.next;
    }

}
