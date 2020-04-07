/*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Solution25ms {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                res.next.val = l1.val;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next.val = l2.val;
                res = res.next;
                l2 = l2.next;
            }
        }
        while (l1 == null && l2 != null) {
            res.next.val = l2.val;
            res = res.next;
            l2 = l2.next;
        }
        while (l2 == null && l1 != null) {
            res.next.val = l1.val;
            res = res.next;
            l1 = l1.next;
        }
        return head.next;
    }
    //解法2，，递归
    public ListNode head=new ListNode(0);
    public ListNode res=head;
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return res.next;
        }
        res.next=new ListNode(0);
        res=res.next;
        if(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.val = l1.val;
                mergeTwoLists(l1.next,l2);
            } else {
                res.val = l2.val;
                mergeTwoLists(l1,l2.next);
            }
        }
        if (l1 == null && l2 != null) {
            res.val=l2.val;
            res.next=l2.next;
        }else  if (l1 != null && l2 == null) {
            res.val=l1.val;
            res.next=l1.next;
        }
        return head.next;
    }
}