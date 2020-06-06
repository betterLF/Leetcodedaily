package List;

/**
 * @authtor liFei
 * @date 2020/6/4-16:53
 */
public class Solution19 {
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
         boolean flag=false;
         ListNode newHead=new ListNode(0);
         newHead.next=head;
         ListNode cur=head;
         int count=1;
         ListNode pre=newHead;
         ListNode last=cur.next;
         while (cur!=null){
             if(count==n){//如果到达第n个结点，则此时的倒数第n个结点就是第一个结点
                 flag=true;//从下一个count开始，只要cur！=null,pre和last就后移
                 count++;
                 cur=cur.next;
                 continue;
             }
             if(flag){
                 pre=pre.next;
                 last=last.next;
                 cur=cur.next;
                 count++;
             }else{
                 cur=cur.next;
                 count++;
             }
         }
             pre.next=last;//删除元素
        return newHead.next;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 哑元节点处理一些边界值时特别有效
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode left = sentinel;
        ListNode right = sentinel;

        for (int i = 0; i <= n; i++) {//遍历结束后right为原链表第n个元素
            right = right.next;
        }

        while (right != null) {//只要right没有到null，right和left就都后移，使得他们之间的间距为n+1
            right = right.next;//结束后left就为倒数第n+1个元素
            left = left.next;
        }

        left.next = left.next.next;//删除倒数第n个元素
        return sentinel.next;
    }
}
