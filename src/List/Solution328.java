package List;

/**
 * @authtor liFei
 * @date 2020/7/7-9:01
 */
public class Solution328 {
    /*
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     */
    public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            ListNode left = new ListNode(0);
            ListNode right = new ListNode(0);
            ListNode r = right;
            boolean flag = true;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = null;
                if (flag) {
                    left.next = cur;
                    left = left.next;
                } else {
                    right.next = cur;
                    right = right.next;
                }
                flag = !flag;
                cur = temp;
            }
            left.next = r.next;//拼接奇结点和偶结点
            return head;
        }
    }

