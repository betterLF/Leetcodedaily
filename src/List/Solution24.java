package List;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
        */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }
       ListNode newHead=new ListNode(0);
       newHead.next=head;
       ListNode cur=head;
       //对第一对进行交换操作
        ListNode temp=cur.next;//存储下一个结点
        ListNode temp1=cur.next.next;//存储下下个结点
        cur.next=temp1;//将当前结点的next指向下下个结点
        newHead.next=temp;//将新头结点的下一个指向下个结点
        temp.next=cur;//将第一个结点存在第二个结点之后
        while(cur.next!=null&&cur.next.next!=null&&cur.next.next!=null){
            ListNode temp2=cur.next;
            ListNode temp3=cur.next.next;
            ListNode temp4=cur.next.next.next;
            cur.next=temp3;
            temp3.next=temp2;
            temp2.next=temp4;
            cur=temp2;
        }
        if(cur.next!=null&&cur.next.next!=null){
            ListNode temp5=cur.next;
            ListNode temp6=cur.next.next;
            cur.next=temp6;
            temp6.next=temp5;
        }
        return newHead.next;
    }
}
