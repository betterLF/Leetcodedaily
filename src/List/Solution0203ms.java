package List;

public class Solution0203ms {
    /*
    实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
     */
    public void deleteNode(ListNode node) {
      ListNode temp=node;
      ListNode last=new ListNode(0);
      while(temp.next!=null){
          temp.val=temp.next.val;
          last=temp;
          temp=temp.next;
      }
      last.next=null;
    }
}
