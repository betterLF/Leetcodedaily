package List;

/**
 * @authtor liFei
 * @date 2020/6/11-7:51
 */
public class Solution82 {
    /*
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
               ListNode newHead=new ListNode(0);
               int curVal=head.val;
               newHead.next=head;
               head=head.next;
               ListNode pre=newHead;
               while (head!=null){
                   if(head.val==curVal){//如果当前结点值与之前的结点值相同
                      pre.next=null;//结果链表的前一个位置的下一个位置为空
                       head=head.next;
                   }else{//如果当前结点值与之前的结点值不同
                       curVal=head.val;//更新比较的值
                       if(pre.next==null) {//如果结果链表当前没有元素
                           pre.next= head;//更新结果链表的后继结点
                       }else{//如果有元素，说明之前pre的next域值只出现了一次，确定不重复，将pre后移
                           pre=pre.next;
                           pre.next=head;
                       }
                       head=head.next;
                   }
               }
               return newHead.next;

    }
}
