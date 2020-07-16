package Design;

import java.util.ArrayList;
import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/7/12-20:53
 */
/*
给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 */
public class Solution382 {
      public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution {
        ArrayList<ListNode> ans;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            ans=new ArrayList<>();
            while (head!=null){
                ans.add(head);
                head=head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
             return ans.get(new Random().nextInt(ans.size())).val;
        }
    }
}
