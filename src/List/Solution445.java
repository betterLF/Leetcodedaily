package List;

/**
 * @authtor liFei
 * @date 2020/7/27-7:02
 */
public class Solution445 {
    /*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     */
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse1= reverse(l1);
        ListNode reverse2 = reverse(l2);
        ListNode head=new ListNode(0);
        ListNode cur=head;
        int c=0;
        while (reverse1!=null&&reverse2!=null){
            int curNum=reverse1.val+reverse2.val+c;
            if(curNum<10){
                cur.next=new ListNode(curNum);
                c=0;
            }else{
                  cur.next=new ListNode(curNum-10);
                  c=1;
            }
            cur=cur.next;
            reverse1=reverse1.next;
            reverse2=reverse2.next;
        }
        while (reverse1!=null){
            int curNum=reverse1.val+c;
            if(curNum<10){
                cur.next=new ListNode(curNum);
                c=0;
            }else{
                cur.next=new ListNode(curNum-10);
                c=1;
            }
            cur=cur.next;
            reverse1=reverse1.next;
        }
        while (reverse2!=null){
            int curNum=reverse2.val+c;
            if(curNum<10){
                cur.next=new ListNode(curNum);
                c=0;
            }else{
                cur.next=new ListNode(curNum-10);
                c=1;
            }
            cur=cur.next;
            reverse2=reverse2.next;
        }
        if(c==1){
            cur.next=new ListNode(1);
        }
        return reverse(head.next);
    }
    private ListNode reverse(ListNode node){
          ListNode head=new ListNode(0);
          ListNode cur=node;
          while (cur!=null){
              ListNode temp=cur.next;
              cur.next=head.next;
              head.next=cur;
              cur=temp;
          }
          return head.next;
    }
}
