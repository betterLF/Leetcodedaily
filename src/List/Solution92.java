package List;

/**
 * @authtor liFei
 * @date 2020/6/12-6:30
 */
public class Solution92 {
    /*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
                ListNode cur=head;
                ListNode newHead=new ListNode(0);
                newHead.next=head;
                ListNode pre=newHead;
                int count=1;
                while (count!=m){
                    pre=cur;
                    cur=cur.next;
                    count++;
                }
                pre.next=reverse(cur,n-m+1);
                return newHead.next;

    }
    //翻转指定位置，返回翻转链表的头部，并将翻转链表尾部与原链表尾部相连
    private ListNode reverse(ListNode reverseStart,int count){
        ListNode newHead=new ListNode(0);
        ListNode cur=reverseStart;
        while (count!=0){//翻转链表
          ListNode temp=cur.next;
            cur.next=newHead.next;
            newHead.next=cur;
            cur=temp;
            count--;
        }
        reverseStart.next=cur;//翻转链表与末尾拼接
        return newHead.next;

    }
}
