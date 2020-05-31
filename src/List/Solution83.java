package List;

/**
 * @authtor liFei
 * @date 2020/5/29-6:29
 */
public class Solution83 {
    /*
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     */
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteDuplicates(ListNode head) {
          if(head==null){
              return null;
          }
       ListNode curList=head;
       int curVal=curList.val;
       ListNode preList=curList;
       curList=curList.next;
       while (curList!=null){
           if(curList.val!=curVal){//如果该值和当前值一样，链表后移
               preList.next=curList;//第一个该元素结点指向该元素
               preList=curList;
               curVal=curList.val;
           }
           curList=curList.next;
       }
       preList.next=null;
       return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        if(head.val == head.next.val){
            head = head.next;
        }
        return head;
    }

}
