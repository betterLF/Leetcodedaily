package List;

/**
 * @authtor liFei
 * @date 2020/6/11-8:44
 */
public class Solution86 {
    /*
    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
     */
    public ListNode partition(ListNode head, int x) {
           ListNode left=new ListNode(0);
           ListNode right=new ListNode(0);
           ListNode curLeft=left;
           ListNode curRight=right;
           while (head!=null){//while结束后left指向其末尾，right指向大于或等于x的结点组合头
               if(head.val<x){
                   curLeft.next=head;
                   curLeft=curLeft.next;
               }else{
                   curRight.next=head;
                   curRight=curRight.next;
               }
               head=head.next;
           }
           curLeft.next=right.next;
           curRight.next=null;
           return left.next;
    }
}
