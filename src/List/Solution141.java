package List;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/6/1-7:49
 */
public class Solution141 {
    /*
    给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> ans=new HashSet<>();
        while (head!=null){
            if(ans.contains(head)){
                return true;
            }else{
                ans.add(head);
                head=head.next;
            }
        }
        return false;
    }
    //快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
