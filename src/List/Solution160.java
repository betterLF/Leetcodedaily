package List;

/**
 * @authtor liFei
 * @date 2020/6/1-8:06
 */
public class Solution160 {
    /*
    编写一个程序，找到两个单链表相交的起始节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode A=headA;
        ListNode B=headB;
        while (A!=B){
            if(A==null){
                    A = headB;
                }else{
                A=A.next;
            }
            if(B==null){
                B = headA;
            }else{
                B=B.next;
            }
        }
        return A;
    }
}
