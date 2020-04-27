package DoublePointer;


/**
 * @authtor liFei
 * @date 2020/4/25-6:57
 */
public class Solution0204ms {
    /*
    编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
    如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     */
    static class  ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(1);
        //head.next.next=new ListNode(8);
//        head.next.next.next=new ListNode(10);
//        head.next.next.next.next=new ListNode(5);
//        head.next.next.next.next.next=new ListNode(2);
//        head.next.next.next.next.next.next=new ListNode(1);
        partition(head,2);
    }
    public static ListNode partition(ListNode head, int x) {
            ListNode left=null;
            ListNode right=null;
            int count=0;
            int ll=-1;
            int rr=-1;
            ListNode cur=head;
            ListNode pre=null;
            ListNode newHead=new ListNode(0);
            newHead.next=head;
            while (cur!=null){
                ListNode temp=cur.next;
                if(cur.val>=x&&right==null){
                    right=cur;
                    pre=right;
                    if(right==head){
                        left=newHead;
                    }
                    rr=count;
                }else if(cur.val<x){
                    ll=count;
                    if(ll>rr&&rr!=-1){
                        cur.next=null;
                        left.next=cur;
                        cur.next=right;
                        pre.next = temp;
                        rr++;
                    }
                    left=cur;
                }else{
                   pre=cur;
                }
                count++;
                cur=temp;
            }
            return newHead.next;
    }
    public static ListNode partition2(ListNode head, int x) {
        ListNode left_head=new ListNode(0);
        ListNode right_head=new ListNode(0);
        ListNode left=left_head;
        ListNode right=right_head;
        ListNode cur=head;
        while (cur!=null){
           if(cur.val<x){//将小于x的组成一个链表
               left.next=cur;
               left=left.next;
           }else{
               right.next=cur;
               right=right.next;
           }
           cur=cur.next;
        }
        right.next=null;//将right后面存在的元素置空(如果一个数大于x，后面跟着小于x的数，那么right=第一个，后面会跟着第二个)
       left.next=right_head.next;//将左边链表的末尾与右边链表的头相连
        return left_head.next;
    }
}
