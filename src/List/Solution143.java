package List;

import java.util.ArrayList;

/**
 * @authtor liFei
 * @date 2020/6/17-8:02
 */
public class Solution143 {
    /*
    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //集合存储
    public void reorderList(ListNode head) {
          if(head==null){
              return;
          }
        ArrayList<ListNode> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head);
            head = head.next;
        }
        int i = 0;
        int j = ans.size() - 1;
        if (ans.size() % 2 == 1) {
            while (i < j) {
                ListNode temp = ans.get(i).next;
                ans.get(i).next = ans.get(j);
                ans.get(j).next = temp;
                i++;
                j--;
            }
            ans.get(i).next=null;
        }else{
            while (j-i>1) {
                ListNode temp = ans.get(i).next;
                ans.get(i).next = ans.get(j);
                ans.get(j).next = temp;
                i++;
                j--;
            }
            ans.get(j).next=null;
        }
    }
    //三步法
    public void reorderList2(ListNode head) {
          if(head==null){
              return;
          }
           //1：找到中间结点
            ListNode fast=head;
            ListNode slow=head;
            while (fast.next!=null&&fast.next.next!=null){//中间结点即为slow
                fast=fast.next.next;
                slow=slow.next;
            }
            //翻转slow后面的链表
             ListNode temp=slow.next;
            slow.next=null;
        ListNode reverseRight = reverse(temp);
        //合并两个链表
          temp=head;
        while (reverseRight!=null){
            ListNode t1=temp.next;
            ListNode t2=reverseRight.next;
            temp.next=reverseRight;
            reverseRight.next=t1;
            temp=t1;
            reverseRight=t2;
        }
    }
    private ListNode reverse(ListNode rightNode){
          ListNode newHead=new ListNode(0);
          ListNode cur=rightNode;
          while (cur!=null){
              ListNode temp=cur.next;
              cur.next=newHead.next;
              newHead.next=cur;
              cur=temp;
          }
          return newHead.next;
    }
    }

