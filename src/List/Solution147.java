package List;
public class Solution147 {
    /*
    对链表进行插入排序。
     */
    public static void main(String[] args) {
        ListNode head=new ListNode(-1);
         head.next=new ListNode(5);
       head.next.next=new ListNode(3);
       head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(0);
        insertionSortList(head);
    }
    public static ListNode insertionSortList(ListNode head) {
       ListNode cur=head;
       ListNode pre=new ListNode(0);//cur与之间元素相比较时记录比较结点的前一个结点
       ListNode newHead=new ListNode(0);
       newHead.next=head;
        cur=cur.next;
       while(cur!=null){
           ListNode temp=cur.next;//保存要插入结点的下一个结点
           ListNode cur2=newHead.next;
                   pre=newHead;
           while(cur2.val<=cur.val&&cur2!=cur){//稳定性
                 pre=cur2;
               cur2=cur2.next;
           }
           //找到要插入结点的前一个结点
           ListNode cur3=pre;
               while (cur3.next != cur) {
                   cur3 = cur3.next;
               }
               if(cur3!=pre) {//万一插入的元素有序，即cur3==pre,cur3.next==cur
                   cur3.next = temp;//将前一个结点指向cur的下一个结点
                   //插入结点
                   pre.next = cur;
                   cur.next = cur2;
               }
               //cur后移
                 cur=temp;
       }
       return newHead.next;
    }
}
