package List;

/**
 * @authtor liFei
 * @date 2020/6/20-8:24
 */
public class Solution203 {
    /*
    删除链表中等于给定值 val 的所有节点。
     */
    public ListNode removeElements(ListNode head, int val) {
             ListNode newHead=new ListNode(0);//定义虚头结点
             ListNode pre=newHead;//定义前驱结点
             newHead.next=head;
             ListNode cur=head;
             while (cur!=null) {
                 ListNode temp = cur.next;
                 if (cur.val == val) {
                     pre.next = temp;//其前驱指向其后驱
                     cur=temp;
                 } else {//如果当前结点值不为value
                     pre = pre.next;//前驱结点后移
                     cur = temp;
                 }
             }
             return newHead.next;
    }
}
