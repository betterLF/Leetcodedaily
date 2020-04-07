package List;
/*
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 */
public class Solution237 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        ListNode temp=node;
        ListNode last=new ListNode(0);
        while(temp.next!=null){
            temp.val=temp.next.val;
            last=temp;
            temp=temp.next;
        }
        last.next=null;
    }
}
