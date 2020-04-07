package List;

import java.util.ArrayList;

public class Solution0207ms {
    /*
    给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，
    而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
     */
public  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
        public  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                 if(headA==null||headB==null){
                 return null;
                    }
                  ListNode tempA=headA;
                  ListNode tempB=headB;
                   while(tempA!=tempB){
                       tempA=tempA==null?tempB:tempA.next;
                       tempB=tempB==null?tempA:tempB.next;
                   }
                   return tempA;
}
}
