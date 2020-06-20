package List;

/**
 * @authtor liFei
 * @date 2020/6/17-7:04
 */
public class Solution142 {
    /*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为表了示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
     */
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
           if(head==null||head.next==null){
               return null;
           }
           ListNode slow=head.next;
           ListNode quick=head.next.next;
           while (slow!=null&&quick!=null){
               if(quick==slow){
                    return CycleFirst(head,quick);
               }
               slow=slow.next;
               if(quick.next!=null) {
                   quick = quick.next.next;
               }else{
                   return null;
               }
           }
           return null;
    }
    private ListNode CycleFirst(ListNode head,ListNode quick){
          ListNode ptr1=head;
          ListNode prt2=quick;
          while (ptr1!=prt2){
              ptr1=ptr1.next;
              prt2=prt2.next;
          }
          return ptr1;

    }
}
